package com.rating.service.controller;

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

import com.rating.service.model.Rating;
import com.rating.service.service.RatingService;

@RestController
@RequestMapping("/v1")
public class RatingController {
	
	@Autowired
	private RatingService reatingService;
	
	@GetMapping("/rating")
	public ResponseEntity<List<Rating>> getAllRatings()
	{
		List<Rating> ratingList= this.reatingService.getAllRatings();
		return new ResponseEntity<List<Rating>>(ratingList,HttpStatus.OK);
	}
	
	@GetMapping("/rating/{ratingId}")
	public ResponseEntity<Rating> getRatingByRatingId(@PathVariable(name="ratingId")String ratingId)
	{
		Rating rating= this.reatingService.getRatingByRatingId(ratingId);
		return new ResponseEntity<Rating>(rating, HttpStatus.OK);
	}
	
	@GetMapping("/rating/user/{userId}")
	public ResponseEntity<List<Rating>> getAllRatingsByUser(@PathVariable(name="userId")String userId)
	{
		List<Rating> ratingsByUserList= this.reatingService.getAllRatingByUser(userId);
		return new ResponseEntity<>(ratingsByUserList,HttpStatus.OK);
	}
	
	@GetMapping("/rating/hotel/{hotelId}")
	public ResponseEntity<List<Rating>> getAllRatingsByHotel(@PathVariable(name="hotelId")String hotelId)
	{
		List<Rating> ratingsByHotelList= this.reatingService.getAllRatingByHotel(hotelId);
		return new ResponseEntity<List<Rating>>(ratingsByHotelList,HttpStatus.OK);
	}
	
	@PutMapping("/rating")
	public ResponseEntity<Rating> createRating(@RequestBody Rating rating)
	{
		Rating updatedRating= this.reatingService.saveRating(rating);
		return new ResponseEntity<Rating>(updatedRating,HttpStatus.CREATED);
	}

	@DeleteMapping("/rating/{ratingId}")
	public ResponseEntity<Rating> deleteRatingByRatingId(@PathVariable(name="ratingId")String ratingId)
	{
		Rating rating= this.reatingService.deleteByRatingId(ratingId);
		return new ResponseEntity<Rating>(rating,HttpStatus.OK);
	}

}
