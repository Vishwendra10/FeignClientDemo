package com.user.service.controller;

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

import com.user.service.model.User;
import com.user.service.service.UserService;

@RestController
@RequestMapping("/v1")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/user")
	public ResponseEntity<List<User>> getAllUsers()
	{
		List<User> userList= this.userService.getAllUsers();
		return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUserById(@PathVariable(name = "id" )String userId)
	{
		User user= this.userService.getUserById(userId);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	
	@PutMapping("/user")
	public ResponseEntity<User> saveUser(@RequestBody User user)
	{
		User updatedUser= this.userService.saveUser(user);
		return new ResponseEntity<User>(updatedUser, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable (name="id") String UserId)
	{
		User deletedUser = this.userService.deleteUserById(UserId);
		return new ResponseEntity<User>(deletedUser, HttpStatus.OK);
	}
	
	
}
