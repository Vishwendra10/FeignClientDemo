package com.hotel.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.service.model.Hotel;
import com.hotel.service.service.HotelService;

@RestController
@RequestMapping("/v1")
public class HotelController {
	
	@Autowired
	private HotelService hotelService;
	
	@GetMapping("/hotel")
	public ResponseEntity<List<Hotel>> getAllHotels()
	{
		List<Hotel> hotelList= this.hotelService.getAllHotels();
		return new ResponseEntity<List<Hotel>>(hotelList, HttpStatus.OK);
	}
	
	@GetMapping("/hotel/{hotelId}")
	public ResponseEntity<Hotel> getHotelById(@PathVariable(name= "hotelId") String hotelId)
	{
		Hotel hotel=this.hotelService.getHotelById(hotelId);
		return new ResponseEntity<Hotel>(hotel, HttpStatus.OK);
	}
	
	@PutMapping("/hotel")
	public ResponseEntity<Hotel> saveHotel(@RequestBody Hotel hotel)
	{
		Hotel updatedHotel= this.hotelService.savehotel(hotel);
		return new ResponseEntity<Hotel>(updatedHotel, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/hotel/{hotelId}")
	public ResponseEntity<Hotel> deleteHotelById(@PathVariable(name= "hotelId") String hotelId)
	{
		Hotel hotel= this.hotelService.deleteHotelById(hotelId);
		return new ResponseEntity<Hotel>(hotel, HttpStatus.OK);
	}
	
	

}
