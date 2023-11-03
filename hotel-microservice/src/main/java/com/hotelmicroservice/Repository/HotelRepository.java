package com.hotelmicroservice.Repository;

import com.hotelmicroservice.Entites.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel,String> {


}
