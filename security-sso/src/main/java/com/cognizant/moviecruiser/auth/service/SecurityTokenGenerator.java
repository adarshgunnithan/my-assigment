package com.cognizant.moviecruiser.auth.service;

import java.util.Map;

import com.cognizant.moviecruiser.auth.domain.User;

public interface SecurityTokenGenerator {

	Map<String,String> generateToken(User user);
}