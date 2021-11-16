package com.onlineshopping.user.service;

import java.util.List;
import java.util.Optional;



import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.onlineshopping.user.dao.UserRepository;
import com.onlineshopping.user.entity.User;
import com.onlineshopping.user.exception.UserNotFoundException;
import com.onlineshopping.user.service.UserService;


@Service
@Transactional
public class UserServiceImpl implements UserService {

	
	@Autowired
	private UserRepository userepository;
	//@Autowired
	//private ProfileRepository repository;


	@Override
	public User addUser(User user) {
		return userepository.save(user);

	}

	@Override
	public User updateUser(User user) {
		Optional<User> userDb = this.userepository.findById(user.getUserId());

		if (userDb.isPresent()) {
			User userUpdate = userDb.get();
			userUpdate.setUserId(user.getUserId());
			userUpdate.setUserName(user.getUserName());
			userUpdate.setUserPassword(user.getUserPassword());
			return userUpdate;
		} else {
			throw new UserNotFoundException("User not found with id : " + user.getUserId());
		}
	}

	@Override
	public List<User> getAllUser() {
		return (List<User>) this.userepository.findAll();
	}

	@Override
	public User getUserById(int userId) {

		Optional<User> userDb = this.userepository.findById(userId);
		if (userDb.isPresent()) {
			return userDb.get();
		} else {
			throw new UserNotFoundException("User not found with id : " + userId);
		}
	}

	@Override
	public void deleteUser(int userId) {
		Optional<User> userDb = this.userepository.findById(userId);
		if (userDb.isPresent()) {
			this.userepository.delete(userDb.get());
		} else {
			throw new UserNotFoundException("User not found with id : " + userId);
		}
	}
	
	/**@Override
	public User showRegistrationForm(User user){
		Optional<Profile> pr = repository.findById(profile.getPrid());

		if(user.setRole(pr==null)) {
		Optional<User> userDb =this.userepository.findById(user.getUserId());
		if(userDb.isEmpty()) {
			User userRegister = userDb.get();
			userRegister.setUserName(user.getUserName());
			userRegister.setUserPassword(user.getUserPassword());
			return userRegister;
		}else {
			if (userDb.isPresent()) {
				return userDb.get();
			}
			//throw new UserNotFoundException("User not found with id : " + user.getUserId());
		}
		}
	}*/
	
	@Override
	public boolean checkLogin(int userId,String userPassword) {
		Optional<User> userDb = this.userepository.findById(userId);
		if(userDb != null) {
			//String userpass = userDb.getByPassword();
			if(userDb.equals(userPassword)) {
				return true;
			}
			else {
				return false;
			}	
		}
		else return false;
	}

	@Override
	public boolean checkIfUserExists(int userId) {
		Optional<User> userDb = this.userepository.findById(userId);
		if(userDb != null) {
			return false;
		}
		else return true;
	}

	
	
}

