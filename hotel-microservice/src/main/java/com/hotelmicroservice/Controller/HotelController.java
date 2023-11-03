package com.hotelmicroservice.Controller;

import com.hotelmicroservice.Entites.Hotel;
import com.hotelmicroservice.Services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {
//Create hotel
@Autowired
private HotelService hotelService;

@PostMapping
public ResponseEntity<Hotel> createhotel(@RequestBody Hotel hotel) {
return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.createHotel(hotel));
}

@GetMapping("/{hotelId}")
public ResponseEntity<Hotel> getHotel(@PathVariable String hotelId){

    return  ResponseEntity.status(HttpStatus.OK).body(hotelService.get(hotelId));
}


@GetMapping
public ResponseEntity<List<Hotel>> getAll(){

    return ResponseEntity.ok(hotelService.getAll());
}
}
