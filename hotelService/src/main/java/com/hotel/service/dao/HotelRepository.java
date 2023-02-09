package com.hotel.service.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.service.model.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, String>{

}
