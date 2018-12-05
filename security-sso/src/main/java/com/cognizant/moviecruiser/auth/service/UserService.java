package com.cognizant.moviecruiser.auth.service;

import com.cognizant.moviecruiser.auth.domain.User;
import com.cognizant.moviecruiser.auth.exception.UserAlreadyExistsException;
import com.cognizant.moviecruiser.auth.exception.UserNotFoundException;

public interface UserService {
	boolean saveUser(User user) throws UserAlreadyExistsException;

	public User findbyUserIdAndPassword(String userId, String password) throws UserNotFoundException;

}