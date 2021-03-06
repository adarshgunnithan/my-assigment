package com.cognizant.moviecruiser.auth.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.cognizant.moviecruiser.auth.domain.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtSecurityTokenGeneratorImpl implements SecurityTokenGenerator{

	@Override
	public Map<String, String> generateToken(User user) {
		
		String jwtToken = "";
		jwtToken= Jwts.builder().setSubject(user.getUserid()).setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS256, "secretkey").compact();
		Map<String,String> map = new HashMap<>();
		map.put("token", jwtToken);
		map.put("message", "User successfully logged in ");
		return map;
	}

}