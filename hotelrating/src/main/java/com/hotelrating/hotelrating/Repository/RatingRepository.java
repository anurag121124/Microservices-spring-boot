package com.hotelrating.hotelrating.Repository;

import com.hotelrating.hotelrating.entites.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RatingRepository extends MongoRepository<Rating,String> {

    //Cutsom Finder Method

    List<Rating>findByUserId(String userId);
    List<Rating>findByHotelId(String hotelId);

}
