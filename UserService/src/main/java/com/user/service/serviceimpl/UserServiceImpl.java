package com.user.service.serviceimpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.user.service.dao.UserRepository;
import com.user.service.exceptions.ResourceNotFoundException;
import com.user.service.external.service.HotelService;
import com.user.service.external.service.RatingService;
import com.user.service.model.Hotel;
import com.user.service.model.Rating;
import com.user.service.model.User;
import com.user.service.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private HotelService hotelService;
	
	@Autowired
	private RatingService ratingService;
	
	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		List<User> userList= this.userRepository.findAll();
		return userList;
	}

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		String randomId= UUID.randomUUID().toString();
		user.setUserId(randomId);
		User updatedUser= this.userRepository.save(user);
		return updatedUser;
	}

	@Override
	public User getUserById(String userId) {
		// TODO Auto-generated method stub
		User user= this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "id", userId));
		
//		Rating[] ratingsArrayByUser=restTemplate.getForObject("http://localhost:8083/v1/rating/user/"+userId, Rating[].class);
//		
//		List<Rating> ratingsByUser= Arrays.stream(ratingsArrayByUser).toList();
		
		List<Rating> ratingsByUser = this.ratingService.getRating(userId);
		
		
		List<Rating> ratingList=ratingsByUser.stream().map(e->
			{
				//Hotel hotel=restTemplate.getForObject("http://localhost:8082/v1/hotel/"+e.getHotelId(), Hotel.class);
				Hotel hotel= this.hotelService.getHotel(e.getHotelId());
				e.setHotel(hotel);
				
				return e;
			}).collect(Collectors.toList());
		
		user.setUserRating(ratingList);
		return user;
	}

	@Override
	public User deleteUserById(String userId) {
		// TODO Auto-generated method stub
		User user=this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "id", userId));
		this.userRepository.deleteById(userId);
		return user;
	}

}
