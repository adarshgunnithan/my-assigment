package com.cts.fsd.moviecruiser.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.fsd.moviecruiser.domain.Movie;
import com.cts.fsd.moviecruiser.exception.MovieAlreadyExistsException;
import com.cts.fsd.moviecruiser.exception.MovieNotFoundException;
import com.cts.fsd.moviecruiser.repository.MovieRepository;

/**
 * @author Adarsh MovieCruiserService bussiness logic implementation
 */
@Service
public class MovieServiceImpl implements MovieService {

	Logger logger = LoggerFactory.getLogger(MovieServiceImpl.class);

	@Autowired
	private MovieRepository movieRepo;

	@Override
	public boolean saveMovie(Movie movie) throws MovieAlreadyExistsException {
		if (movie.getMovieId() != null) {
			final Optional<Movie> object = movieRepo.findById(movie.getId());
			if (object.isPresent()) {
				throw new MovieAlreadyExistsException("Could not save movie, Movie already exists");
			}
		}
		movieRepo.save(movie);
		return true;
	}

	@Override
	public Movie updateMovie(Movie movie) throws MovieNotFoundException {
		final Movie object = movieRepo.findById(movie.getId()).orElse(null);
		if (object == null) {
			throw new MovieNotFoundException("Could not save movie, Movie already exists");
		}
		movie.setComment(movie.getComment());
		movieRepo.save(movie);
		return movie;
	}

	@Override
	public boolean deleteMovieById(int movieId) throws MovieNotFoundException {
		final Movie object = movieRepo.findById(movieId).orElse(null);
		if (object == null) {
			throw new MovieNotFoundException("Could not save movie, Movie already exists");
		}
		movieRepo.delete(object);
		return true;
	}

	

	@Override
	public Movie getMovieById(int movieId) throws MovieNotFoundException {
		final Movie object = movieRepo.findById(movieId).orElse(null);
		if (object == null) {
			throw new MovieNotFoundException("Could not save movie, Movie already exists");
		}
		return object;
	}

	

	@Override
	public List<Movie> getAllMovies() {
		return (List<Movie>) movieRepo.findAll();
	}

	@Override
	public List<Movie> getMyMovies(String userId) {
		return movieRepo.findByUserId(userId);
	}

}
