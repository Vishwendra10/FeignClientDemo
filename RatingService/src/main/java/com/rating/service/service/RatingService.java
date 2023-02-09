package com.rating.service.service;

import java.util.List;

import com.rating.service.model.Rating;

public interface RatingService {
	
	//create
	public Rating saveRating(Rating rating);
	
	//delete by ratingId
	public Rating deleteByRatingId(String ratingId);
	
	//getAllRating
	public List<Rating> getAllRatings();
	
	//get by ratingId
	public Rating getRatingByRatingId(String ratingId);
	
	//get all by userId
	public List<Rating> getAllRatingByUser(String userId);
	
	//get all by hotelId
	public List<Rating> getAllRatingByHotel(String hotelId);
	
}
