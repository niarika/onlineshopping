package com.onlineshopping.user.service;

import java.util.List;

import com.onlineshopping.user.entity.User;

public interface UserService {
	User addUser(User user);

	User updateUser(User user);

	List<User> getAllUser();

	User getUserById(int userId);

	void deleteUser(int userId);
	
	//User showRegistrationForm(User user);
	
	boolean checkLogin(int userId, String userPassword);

	boolean checkIfUserExists(int userId);


}