package com.cts.fsd.moviecruiser.service;

import java.util.List;

import com.cts.fsd.moviecruiser.domain.Movie;
import com.cts.fsd.moviecruiser.exception.MovieAlreadyExistsException;
import com.cts.fsd.moviecruiser.exception.MovieNotFoundException;

/**
 * @author Adarsh
 *MovieCruiserService API
 */

public interface MovieService {
	
	/**
	 * API to add movie to watch list
	 * @param movie
	 * @return boolean
	 */
	public boolean saveMovie(Movie movie) throws MovieAlreadyExistsException;
	
	/**
	 * API to update movie in the watch list(for now only comments is updating)
	 * @param movie
	 * @return
	 */
	public Movie updateMovie(Movie movie) throws MovieNotFoundException;
	
	/**
	 * API to remove movie from watch list
	 * @param movieId
	 * @return
	 */
	public boolean deleteMovieById(int movieId) throws MovieNotFoundException;
	

	
	/**
	 * API to get movie by movie id
	 * @param movieId
	 * @return Movie
	 * @throws MovieNotFoundException
	 */
	public Movie getMovieById(int movieId)throws MovieNotFoundException;
	

	List<Movie> getAllMovies();
	

	List<Movie> getMyMovies(String userId);

}
