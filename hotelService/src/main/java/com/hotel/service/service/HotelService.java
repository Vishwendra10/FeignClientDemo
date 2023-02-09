package com.hotel.service.service;

import java.util.List;

import com.hotel.service.model.Hotel;

public interface HotelService {
	
	//create
	public Hotel savehotel(Hotel hotel);
	
	//get all
	public List<Hotel> getAllHotels();
	
	//get single
	public Hotel getHotelById(String hotelId);
	
	//deleteHotel
	public Hotel deleteHotelById(String hotelId);

}
