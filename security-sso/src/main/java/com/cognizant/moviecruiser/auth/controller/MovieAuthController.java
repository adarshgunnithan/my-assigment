package com.cognizant.moviecruiser.auth.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.moviecruiser.auth.domain.User;
import com.cognizant.moviecruiser.auth.exception.UserAlreadyExistsException;
import com.cognizant.moviecruiser.auth.service.UserService;
import com.cognizant.moviecruiser.auth.service.SecurityTokenGenerator;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping(path = "/api/userservice")
public class MovieAuthController {

	private UserService userservice;

	@Autowired
	private SecurityTokenGenerator tokenGenerator;

	@Autowired
	public MovieAuthController(final UserService movieService) {
		this.userservice = movieService;
	}

	@PostMapping(path = "/register", produces = "application/json")
	public ResponseEntity<?> registerUser(@RequestBody User user) {
		try {
			userservice.saveUser(user);
			return new ResponseEntity<String>("User registered successfully", HttpStatus.OK);
		} catch (UserAlreadyExistsException e) {
			return new ResponseEntity<String>("{ \"message\":\"" + e.getMessage() + "\"}", HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping(value = "/login")
	public ResponseEntity<?> loginUser(@RequestBody User logindetail) {
		try {
			String userId = logindetail.getUserid();
			String password = logindetail.getPassword();

			if (userId == null || password == null) {
				throw new Exception("username and password can be empty");
			}
			User user = userservice.findbyUserIdAndPassword(userId, password);
			if (user == null) {
				throw new Exception("user with given Id doesnot exist");
			}
			if (user.getPassword() == password) {
				throw new Exception("Invalid login credentials, please check username or password");
			}
			Map<String, String> map = tokenGenerator.generateToken(user);
			return new ResponseEntity<Map<String, String>>(map, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("{ \"message\":\"" + e.getMessage() + "\"}", HttpStatus.UNAUTHORIZED);
		}

	}

}