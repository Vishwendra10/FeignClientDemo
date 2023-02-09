package com.rating.service.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rating.service.model.Rating;

public interface RatingRepository extends JpaRepository<Rating, String>{
	
	//Custom finder Method
	
	List<Rating> findByUserId(String userId);
	
	List<Rating> findByHotelId(String hotelId);

}
