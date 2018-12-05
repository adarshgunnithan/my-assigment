package com.cognizant.moviecruiser.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.moviecruiser.auth.domain.User;

public interface UserRepository extends JpaRepository<User, String> {

	

	User findByUseridAndPassword(String userid, String password);
}