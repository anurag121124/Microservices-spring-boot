package com.hotelrating.hotelrating.Impl;

import com.hotelrating.hotelrating.Repository.RatingRepository;
import com.hotelrating.hotelrating.Service.RatingService;
import com.hotelrating.hotelrating.entites.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public Rating createRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getrating() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Rating> getRatingByUserId(String userId) {
        return ratingRepository.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingbyHotelId(String hotelId) {
        return ratingRepository.findByHotelId(hotelId);
    }
}
