package com.cts.fsd.moviecruiser.controller;

import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.fsd.moviecruiser.domain.Movie;
import com.cts.fsd.moviecruiser.exception.MovieAlreadyExistsException;
import com.cts.fsd.moviecruiser.exception.MovieNotFoundException;
import com.cts.fsd.moviecruiser.service.MovieService;

import io.jsonwebtoken.Jwts;

/**
 * @author Adarsh MovieCruiserController: API to expose movie services
 */

@RestController
@RequestMapping("api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class MovieController {

	@Autowired
	private MovieService movieServiceImpl;

	/**
	 * API to save movie to watch list
	 * @param movie
	 * @return responseEntity
	 */
	@PostMapping("/movie/add")
	public ResponseEntity<?> saveNewMovie(@RequestBody Movie movie, HttpServletRequest request) {
		ResponseEntity<?> responseEntity = null;
		final String authHeader = request.getHeader("authorization");
		final String token = authHeader.substring(7);
		String userId=Jwts.parser().setSigningKey("secretkey").parseClaimsJws(token).getBody().getSubject();
		try {
			movie.setUserId(userId);
			movieServiceImpl.saveMovie(movie);
			responseEntity = new ResponseEntity<Movie>(movie, HttpStatus.CREATED);
		} catch (MovieAlreadyExistsException exception) {
			responseEntity = new ResponseEntity<String>("{ message :" + exception.getMessage() + "}",
					HttpStatus.CONFLICT);
		}
		return responseEntity;
	}

	/**
	 * API to update movie comments
	 * @param id
	 * @param movie
	 * @return responseEntity
	 */
	//@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping(path = "/movie/update/{id}")
	public ResponseEntity<?> updateMovie(@PathVariable("id") Integer id, @RequestBody Movie movie) {
		ResponseEntity<?> responseEntity = null;
		try {
			Movie updatedMovie = movieServiceImpl.updateMovie(movie);
			responseEntity = new ResponseEntity<Movie>(updatedMovie, HttpStatus.OK);
		} catch (MovieNotFoundException exception) {
			responseEntity = new ResponseEntity<String>("{ message :" + exception.getMessage() + "}",
					HttpStatus.CONFLICT);
		}
		return responseEntity;
	}

	/**
	 * API to delete movie by movie id
	 * @param id
	 * @return responseEntity
	 */
	//@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping(path = "/movie/delete/{id}")
	public ResponseEntity<?> deleteMovie(@PathVariable("id") int id) {
		ResponseEntity<?> responseEntity = null;
		try {
			boolean deleteStatus = movieServiceImpl.deleteMovieById(id);
			responseEntity = new ResponseEntity<Boolean>(deleteStatus, HttpStatus.OK);
		} catch (MovieNotFoundException exception) {
			responseEntity = new ResponseEntity<String>("{ message :" + exception.getMessage() + "}",
					HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}

	/**
	 * API to get all movies
	 * @return responseEntity
	 */
	@GetMapping(path="/movies")
	public ResponseEntity<?> getAllMovies(final ServletRequest req,final ServletResponse res) {
		ResponseEntity<?> responseEntity = null;

		final HttpServletRequest request = (HttpServletRequest)req;
		final String authHeader = request.getHeader("authorization");
		final String token = authHeader.substring(7);
		String userId=Jwts.parser().setSigningKey("secretkey").parseClaimsJws(token).getBody().getSubject();
		List<Movie> movies = movieServiceImpl.getMyMovies(userId);
		responseEntity = new ResponseEntity<List<Movie>>(movies, HttpStatus.OK);
		return responseEntity;
	}
	
	/**
	 * API to get movie by movie id
	 * @param id
	 * @return responseEntity
	 */
	@GetMapping(path="/movie/{id}")
	public ResponseEntity<?> getMovieById(@PathVariable("id") int id) {
		ResponseEntity<?> responseEntity = null;
		try{
		Movie movie = movieServiceImpl.getMovieById(id);
		responseEntity = new ResponseEntity<Movie>(movie, HttpStatus.OK);
		}catch(MovieNotFoundException exception){
			responseEntity = new ResponseEntity<String>("{ message :" + exception.getMessage() + "}",
					HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}
}
