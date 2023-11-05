package com.userservice.services.impl;

import com.userservice.Entity.Hotel;
import com.userservice.Entity.Rating;
import com.userservice.Entity.User;
import com.userservice.repositories.UserRepositories;
import com.userservice.services.userServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.userservice.exceptions.ResourceNotFoundExceptions;

@Service
public class userServiceImpl implements userServices {

    private static final Logger logger = LoggerFactory.getLogger(userServiceImpl.class);
    @Autowired
    private UserRepositories userRepositories;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public User saveUser(User user) {
        String ramdomUserId = UUID.randomUUID().toString();
        user.setUserId(ramdomUserId);
        return userRepositories.save(user);
    }

    @Override
    public List<User> getallUser() {

        return userRepositories.findAll();
    }

    @Override
    public User getUser(String userId) {
        User user = userRepositories.findById(userId).orElseThrow(() -> new ResourceNotFoundExceptions("User is not found with the id " + userId));

        // Assuming you are using RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Rating[]> responseEntity = restTemplate.exchange("http://localhost:8081/users/" + user.getUserId(), HttpMethod.GET, null, Rating[].class);
        Rating[] ratingArray = responseEntity.getBody();

        if (ratingArray == null) {
            // Handle the case where no ratings were found
            logger.info("No ratings found for user: {}", userId);
        } else {
            List<Rating> ratings = Arrays.asList(ratingArray);

            List<Rating> ratingList = ratings.stream().map(rating -> {
                ResponseEntity<Hotel> hotelResponseEntity = restTemplate.exchange("http://localhost:8083/hotels/" + rating.getHotelId(), HttpMethod.GET, null, Hotel.class);
                Hotel hotel = hotelResponseEntity.getBody();
                logger.info("Response status code: {}", hotelResponseEntity.getStatusCode());
                rating.setHotel(hotel);
                return rating;
            }).collect(Collectors.toList());

            user.setRatings(ratingList);
        }

        return user;
    }
}