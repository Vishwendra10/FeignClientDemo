package com.user.service.external.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.user.service.model.Rating;

@FeignClient(name= "rating-service", url="localhost:8083/v1")
public interface RatingService {
	
	@GetMapping("/rating/user/{userId}")
	public List<Rating> getRating(@PathVariable(name="userId")String userId);

}
