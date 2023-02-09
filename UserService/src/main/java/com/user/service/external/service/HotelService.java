package com.user.service.external.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.user.service.model.Hotel;

@FeignClient(name = "hotel-service",url="localhost:8082/v1")
public interface HotelService {
	
	@GetMapping("/hotel/{hotelId}")
	public Hotel getHotel(@PathVariable("hotelId") String hotelID);
}
