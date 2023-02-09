package com.hotel.service.serviceimpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.service.dao.HotelRepository;
import com.hotel.service.exception.ResourceNotFoundException;
import com.hotel.service.model.Hotel;
import com.hotel.service.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService{
	
	@Autowired
	private HotelRepository hotelRepository;
	

	@Override
	public Hotel savehotel(Hotel hotel) {
		// TODO Auto-generated method stub
		String randomId=UUID.randomUUID().toString();
		hotel.setHotelId(randomId);
		Hotel updatedHotel= this.hotelRepository.save(hotel);
		return updatedHotel;
	}

	@Override
	public List<Hotel> getAllHotels() {
		// TODO Auto-generated method stub
		List<Hotel> hotelList= this.hotelRepository.findAll();
		return hotelList;
	}

	@Override
	public Hotel getHotelById(String hotelId) {
		// TODO Auto-generated method stub
		Hotel hotel= this.hotelRepository.findById(hotelId).orElseThrow(()-> new ResourceNotFoundException("Hotel", "id", hotelId));
		return hotel;
	}
	
	public Hotel deleteHotelById(String hotelId) {
		// TODO Auto-generated method stub
		Hotel hotel=this.hotelRepository.findById(hotelId).orElseThrow(()-> new ResourceNotFoundException("Hotel", "id", hotelId));
		this.hotelRepository.deleteById(hotelId);
		return hotel;
	}

}
