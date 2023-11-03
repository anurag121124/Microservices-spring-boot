package com.hotelrating.hotelrating.Service;

import com.hotelrating.hotelrating.entites.Rating;

import java.util.List;

public interface RatingService {


    Rating createRating (Rating rating);

    List<Rating> getrating();

    List<Rating> getRatingByUserId(String userId);

    List <Rating> getRatingbyHotelId(String hotelId);

}
