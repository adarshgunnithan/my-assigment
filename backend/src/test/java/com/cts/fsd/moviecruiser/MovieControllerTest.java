package com.cts.fsd.moviecruiser;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.cts.fsd.moviecruiser.controller.MovieController;
import com.cts.fsd.moviecruiser.domain.Movie;
import com.cts.fsd.moviecruiser.service.MovieService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@RunWith(SpringRunner.class)
@WebMvcTest(MovieController.class)

public class MovieControllerTest {

	@Autowired
	private transient MockMvc mvc;
	@MockBean
	private transient MovieService service;
	private transient Movie movie;
	static List<Movie> movies;
	String token ="eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZGFyc2giLCJpYXQiOjE1NDMzMDM5OTV9.UI31jRdsRM95ZXs6oKNSp5j-euo0YLUE6KkXJF72Lxk";

	@Before
	public void SetUp() {
		movies = new ArrayList<>();
		
		movie = new Movie("12", "POC", "goodMovie",12, "comment", Calendar.getInstance(),"www.idmb.com/poster","fun",5000,"john123"); ;
		movies.add(movie);
		movie = new Movie("13", "POC", "goodMovie",12, "comment", Calendar.getInstance(),"www.idmb.com/poster","fun",5000,"john123");
		movies.add(movie);
	}

	@Test
	public void testSaveNewMovieSucess() throws Exception {
		String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxMDAiLCJpYXQiOjE1NDE4MjUyMDB9.j-XY2GFppw0jfhasOx8TnMFi3iZlkcCLNwRJukMel3Q";
		
		movie.setComment("Not that much Good");
		when(service.saveMovie(movie)).thenReturn(true);
		mvc.perform(post("/api/v1/movie/add").header("authorization","Bearer "+token).contentType(MediaType.APPLICATION_JSON).content(jsonToString(movie)))
				.andExpect(status().isCreated());
		verify(service, times(1)).saveMovie(Mockito.any(Movie.class));
		verifyNoMoreInteractions(service);
	}

	@Test
	public void testUpdateMovieSucess() throws Exception {
		String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxMDAiLCJpYXQiOjE1NDE4MjUyMDB9.j-XY2GFppw0jfhasOx8TnMFi3iZlkcCLNwRJukMel3Q";
		
		movie.setComment("Not so Good");
		when(service.updateMovie(movie)).thenReturn(movies.get(0));
		mvc.perform(put("/api/v1//movie/update/{id}", 1).header("authorization","Bearer "+token).contentType(MediaType.APPLICATION_JSON).content(jsonToString(movie)))
				.andExpect(status().isOk());
		verify(service, times(1)).updateMovie(Mockito.any(Movie.class));
		verifyNoMoreInteractions(service);
	}

	private static String jsonToString(final Object obj) throws JsonProcessingException {
		// TODO Auto-generated method stub
		String result;
		try {
			final ObjectMapper mapper = new ObjectMapper();
			final String jsonContent = mapper.writeValueAsString(obj);
			result = jsonContent;
		} catch (JsonProcessingException e) {
			// TODO: handle exception
			result = "Json Processing error";
		}
		return result;
	}

	@Test
	public void testDeleteMovieById() throws Exception {
		//String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxMDAiLCJpYXQiOjE1NDE4MjUyMDB9.j-XY2GFppw0jfhasOx8TnMFi3iZlkcCLNwRJukMel3Q";
		
		when(service.deleteMovieById(1)).thenReturn(true);
		mvc.perform(delete("/api/v1/movie/delete/{id}", 1).header("authorization","Bearer "+token)).andExpect(status().isOk());
		verify(service, times(1)).deleteMovieById(1);
		verifyNoMoreInteractions(service);
	}

	@Test
	public void testFetchMovieById() throws Exception {
		//String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxMDAiLCJpYXQiOjE1NDE4MjUyMDB9.j-XY2GFppw0jfhasOx8TnMFi3iZlkcCLNwRJukMel3Q";
		
		when(service.getMovieById(1)).thenReturn(movies.get(0));
		mvc.perform(get("/api/v1/movie/{id}", 1).header("authorization","Bearer "+token)).andExpect(status().isOk());
		verify(service, times(1)).getMovieById(1);
		verifyNoMoreInteractions(service);
	}



}