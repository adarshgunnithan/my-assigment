package com.cognizant.moviecruiser.auth.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.moviecruiser.auth.domain.User;
import com.cognizant.moviecruiser.auth.exception.UserAlreadyExistsException;
import com.cognizant.moviecruiser.auth.exception.UserNotFoundException;
import com.cognizant.moviecruiser.auth.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private final transient UserRepository userRepo;

	@Autowired
	public UserServiceImpl(UserRepository movieRepo) {
		super();
		this.userRepo = movieRepo;
	}


	@Override
	public boolean saveUser(User user) throws UserAlreadyExistsException {
		final Optional<User> object = userRepo.findById(user.getUserid());
		if (object.isPresent()) {
			throw new UserAlreadyExistsException("Could not save User,User already exists!");
		}
		userRepo.save(user);
		return true;
	}

	@Override
	public User findbyUserIdAndPassword(String userid, String password) throws UserNotFoundException {
		
		final User user = userRepo.findByUseridAndPassword(userid, password);
		if(user==null) {
			throw new UserNotFoundException("User id and password mismatch");
		}
		return user;
	}
}