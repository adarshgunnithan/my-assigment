package com.cts.fsd.moviecruiser.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.fsd.moviecruiser.domain.Movie;

/**
 * @author Adarsh
 *Dao layer API for movie cruiser app
 */
public interface MovieRepository extends JpaRepository<Movie, Integer> {
	List<Movie> findByUserId(String userId);

}
