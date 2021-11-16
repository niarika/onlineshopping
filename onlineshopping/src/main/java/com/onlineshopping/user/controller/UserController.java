package com.onlineshopping.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.onlineshopping.user.entity.User;
import com.onlineshopping.user.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService userservice;

	@GetMapping("/user")
	public List<User> getAllUser() {
		System.out.println(userservice.getAllUser());
		return userservice.getAllUser();
	}

	@PostMapping("/user/add")
	public void addUser(@RequestBody User user) {
		userservice.addUser(user);
	}

	@DeleteMapping("/user/delete/{userId}")
	public void deleteUser(@PathVariable(required = true) int userId) {
		userservice.deleteUser(userId);
	}

	@GetMapping("/user/get/{userId}")
	public User getUserById(@PathVariable(required = true) int userId) {
		return userservice.getUserById(userId);
	}

	@PostMapping("/user/update/{userId}")
	public void updateUser(@RequestBody User user) {
		userservice.updateUser(user);
	}
	
	/**@PostMapping("/user/register/{userId}")
	public void userRegister(@RequestBody User user) {
		userservice.showRegistrationForm(user);
	}*/

}