package com.cts.fsd.moviecruiser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cts.fsd.moviecruiser.domain.Movie;
import com.cts.fsd.moviecruiser.exception.MovieAlreadyExistsException;
import com.cts.fsd.moviecruiser.exception.MovieNotFoundException;
import com.cts.fsd.moviecruiser.repository.MovieRepository;
import com.cts.fsd.moviecruiser.service.MovieServiceImpl;


public class MovieCruiserServiceTest {

	@Mock
	private transient MovieRepository movieRepo;
	private transient Movie movie;
	@InjectMocks
	private transient MovieServiceImpl movieServiceImpl;
	transient Optional<Movie> options;

	@Before
	public void setupMock() {
		MockitoAnnotations.initMocks(this);

		movie = new Movie("12", "POC", "goodMovie",12, "comment", Calendar.getInstance(),"www.idmb.com/poster","fun",5000,"john123");

		options = Optional.of(movie);
	}

	@Test
	public void testMockCreation() {
		assertNotNull("jpaRepository creation fails:use @injectMocks on movieServiceImpl", movie);
	}

	@Test
	public void testSaveMovieSuccess() throws MovieAlreadyExistsException {
		when(movieRepo.save(movie)).thenReturn(movie);
		final boolean flag = movieServiceImpl.saveMovie(movie);
		assertTrue("saving movie failed,the call to movieDAOImpl is returning false,check this", flag);
		verify(movieRepo, times(1)).save(movie);
	}




	@Test
	public void testDeleteMovieById() throws MovieNotFoundException {
		when(movieRepo.findById(1)).thenReturn(options);
		doNothing().when(movieRepo).delete(movie);
		final boolean flag = movieServiceImpl.deleteMovieById(1);
		assertTrue(flag);
		
	}

	@Test
	public void testGetMovieById() throws MovieNotFoundException {
		when(movieRepo.findById(1)).thenReturn(options);
		final Movie movie1 = movieServiceImpl.getMovieById(1);
		assertEquals(movie1, movie);
	
	}

	@Test
	public void testGetAllMovies() {
		final List<Movie> movieList = new ArrayList<>(1);
		when(movieRepo.findAll()).thenReturn(movieList);
		final List<Movie> movies1 = movieServiceImpl.getAllMovies();
		assertEquals(movieList, movies1);
		verify(movieRepo, times(1)).findAll();
	}

}
