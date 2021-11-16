package com.onlineshopping.user.dao;

import org.springframework.data.repository.CrudRepository;

import com.onlineshopping.user.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}
