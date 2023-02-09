package com.rating.service.serviceimpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rating.service.dao.RatingRepository;
import com.rating.service.exception.ResourceNotFoundException;
import com.rating.service.model.Rating;
import com.rating.service.service.RatingService;

@Service
public class RatingServiceImpl implements RatingService{
	
	@Autowired
	private RatingRepository ratingRepository;

	@Override
	public Rating saveRating(Rating rating) {
		// TODO Auto-generated method stub
		String randomId= UUID.randomUUID().toString();
		rating.setRatingId(randomId);
		Rating updatedRating= this.ratingRepository.save(rating);
		return updatedRating;
	}

	@Override
	public Rating deleteByRatingId(String ratingId) {
		// TODO Auto-generated method stub
		Rating rating= this.ratingRepository.findById(ratingId).orElseThrow(()-> new ResourceNotFoundException("Rating","id",ratingId));
		this.ratingRepository.deleteById(ratingId);
		return rating;
	}

	@Override
	public List<Rating> getAllRatings() {
		// TODO Auto-generated method stub
		List<Rating> ratingList=this.ratingRepository.findAll();
		return ratingList;
	}

	@Override
	public Rating getRatingByRatingId(String ratingId) {
		// TODO Auto-generated method stub
		Rating rating= this.ratingRepository.findById(ratingId).orElseThrow(()-> new ResourceNotFoundException("Rating", "id", ratingId));
		return rating;
	}

	@Override
	public List<Rating> getAllRatingByUser(String userId) {
		// TODO Auto-generated method stub
		List<Rating> ratingsByUser= this.ratingRepository.findByUserId(userId);
		return ratingsByUser;
	}

	@Override
	public List<Rating> getAllRatingByHotel(String hotelId) {
		// TODO Auto-generated method stub
		List<Rating> ratingsByHotel= this.ratingRepository.findByHotelId(hotelId);
		return ratingsByHotel;
	}

}
