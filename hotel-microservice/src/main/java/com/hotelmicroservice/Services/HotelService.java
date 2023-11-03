package com.hotelmicroservice.Services;

import com.hotelmicroservice.Entites.Hotel;

import java.util.List;

public interface HotelService {

    Hotel createHotel(Hotel hotel);

    List<Hotel>getAll();

    Hotel get(String id);

}
