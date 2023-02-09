package com.user.service.service;

import java.util.List;

import com.user.service.model.User;

public interface UserService {
	
	//get all users
	public List<User> getAllUsers();
	
	//create user
	public User saveUser(User user);
	
	//get user by id
	public User getUserById(String userId);
	
	//delete user
	public User deleteUserById(String userId);

}
