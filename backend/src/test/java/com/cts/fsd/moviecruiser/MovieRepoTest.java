package com.cts.fsd.moviecruiser;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cts.fsd.moviecruiser.domain.Movie;
import com.cts.fsd.moviecruiser.repository.MovieRepository;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Transactional
public class MovieRepoTest {
	@Autowired
	private MovieRepository repo;

	public void setRepo(final MovieRepository repo) {
		this.repo = repo;
	}

	/*@Test
	public void testSaveMovie() throws Exception {

		Movie movie = new Movie("12", "POC", "goodMovie",12, "comment", Calendar.getInstance(),"www.idmb.com/poster","fun",5000,"john123");

		repo.save( movie);
		final Movie retrivedMovie = repo.getOne(12);
		assertThat(retrivedMovie.getMovieId()).isEqualTo(12);
	}*/

//	@Test
//	public void testUpdateMovie() throws Exception {
//		repo.save(new Movie(1L,"POC","goodMovie",50,"comment"));
//		final Movie movie = repo.getOne(1L);
//		assertEquals(movie.getMovieName(), "POC");
//		movie.setComment("hi");
//		repo.save(movie);
//		final Movie tempMovie = repo.getOne(1L);
//		assertEquals("hi", tempMovie.getComment());
//	}

	@Test
	public void testDeleteMovie() throws Exception {
		Movie movie = new Movie("12", "POC", "goodMovie",12, "comment", Calendar.getInstance(),"www.idmb.com/poster","fun",5000,"john123");

		repo.save(movie);
		final Movie retrivedMovie = repo.getOne(1);
		assertEquals(movie.getMovieName(), "POC");
		repo.delete(movie);
		assertEquals(Optional.empty(), repo.findById(1));
	}

//	@Test
//	public void testGetMovie() throws Exception {
//		try{
//		repo.save(new Movie(1L,"POC","goodMovie",50,"comment"));
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		final Movie movie = repo.getOne(1L);
//		assertEquals(movie.getMovieName(), "POC");
//	}

	@Test
	public void testGetAllMovies() throws Exception {
		Movie movie1 = new Movie("12", "POC", "goodMovie",12, "comment", Calendar.getInstance(),"www.idmb.com/poster","fun",5000,"john123");
		Movie movie2 = new Movie("12", "POC", "goodMovie",12, "comment", Calendar.getInstance(),"www.idmb.com/poster","fun",5000,"john123");
		repo.save(movie1);
		repo.save(movie2);
		final List<Movie> movies = repo.findAll();
		assertEquals(movies.get(0).getMovieName(), "POC");
	}
}
