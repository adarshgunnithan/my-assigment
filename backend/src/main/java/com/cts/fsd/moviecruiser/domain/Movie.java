package com.cts.fsd.moviecruiser.domain;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Adarsh Domain object to represent movie
 */
@Entity
@Table(name = "movie")
public class Movie {



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "movie_id")
	private String movieId;
	@Column(name = "movie_name")
	private String movieName;
	@Column(name="overview",length=2000)
	private String overview;
	private int views;
	private String comment;
	@Temporal(TemporalType.DATE)
	@Column(name = "release_date")
	private Calendar releaseDate;
	@Column(name = "poster_url")
	private String posterUrl;
	private String genere;
	private Integer budject;
	@Column(name = "user_id")
	private String userId;
	
	private String popularity;
	private String vote_average;
	private String vote_count;
	
	
	

	public String getPopularity() {
		return popularity;
	}

	public void setPopularity(String popularity) {
		this.popularity = popularity;
	}

	public String getVote_average() {
		return vote_average;
	}

	public void setVote_average(String vote_average) {
		this.vote_average = vote_average;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((budject == null) ? 0 : budject.hashCode());
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + ((genere == null) ? 0 : genere.hashCode());
		result = prime * result + id;
		result = prime * result + ((movieId == null) ? 0 : movieId.hashCode());
		result = prime * result + ((movieName == null) ? 0 : movieName.hashCode());
		result = prime * result + ((overview == null) ? 0 : overview.hashCode());
		result = prime * result + ((popularity == null) ? 0 : popularity.hashCode());
		result = prime * result + ((posterUrl == null) ? 0 : posterUrl.hashCode());
		result = prime * result + ((releaseDate == null) ? 0 : releaseDate.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + views;
		result = prime * result + ((vote_average == null) ? 0 : vote_average.hashCode());
		result = prime * result + ((vote_count == null) ? 0 : vote_count.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", movieId=" + movieId + ", movieName=" + movieName + ", overview=" + overview
				+ ", views=" + views + ", comment=" + comment + ", releaseDate=" + releaseDate + ", posterUrl="
				+ posterUrl + ", genere=" + genere + ", budject=" + budject + ", userId=" + userId + ", popularity="
				+ popularity + ", vote_average=" + vote_average + ", vote_count=" + vote_count + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		if (budject == null) {
			if (other.budject != null)
				return false;
		} else if (!budject.equals(other.budject))
			return false;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (genere == null) {
			if (other.genere != null)
				return false;
		} else if (!genere.equals(other.genere))
			return false;
		if (id != other.id)
			return false;
		if (movieId == null) {
			if (other.movieId != null)
				return false;
		} else if (!movieId.equals(other.movieId))
			return false;
		if (movieName == null) {
			if (other.movieName != null)
				return false;
		} else if (!movieName.equals(other.movieName))
			return false;
		if (overview == null) {
			if (other.overview != null)
				return false;
		} else if (!overview.equals(other.overview))
			return false;
		if (popularity == null) {
			if (other.popularity != null)
				return false;
		} else if (!popularity.equals(other.popularity))
			return false;
		if (posterUrl == null) {
			if (other.posterUrl != null)
				return false;
		} else if (!posterUrl.equals(other.posterUrl))
			return false;
		if (releaseDate == null) {
			if (other.releaseDate != null)
				return false;
		} else if (!releaseDate.equals(other.releaseDate))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (views != other.views)
			return false;
		if (vote_average == null) {
			if (other.vote_average != null)
				return false;
		} else if (!vote_average.equals(other.vote_average))
			return false;
		if (vote_count == null) {
			if (other.vote_count != null)
				return false;
		} else if (!vote_count.equals(other.vote_count))
			return false;
		return true;
	}

	public String getVote_count() {
		return vote_count;
	}

	public void setVote_count(String vote_count) {
		this.vote_count = vote_count;
	}

	public Movie() {
		super();
	}

	public Movie(String movieId, String movieName, String overview, int views, String comment,Calendar releaseDate,
			String posterUrl, String genere, Integer budject, String userId) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.overview = overview;
		this.views = views;
		this.comment = comment;
		this.releaseDate = releaseDate;
		this.posterUrl = posterUrl;
		this.genere = genere;
		this.budject = budject;
		this.userId = userId;
	}

	public Movie(String movieId, String movieName, String overview, int views, String comment,String userId) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.overview = overview;
		this.views = views;
		this.comment = comment;
		this.userId=userId;
	}
	@JsonProperty("release_date")
	public Calendar getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Calendar releaseDate) {
		this.releaseDate = releaseDate;
	}
	@JsonProperty("poster_path")
	public String getPosterUrl() {
		return posterUrl;
	}

	public void setPosterUrl(String posterUrl) {
		this.posterUrl = posterUrl;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	public Integer getBudject() {
		return budject;
	}

	public void setBudject(Integer budject) {
		this.budject = budject;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	@JsonProperty("title")
	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getOverview() {
		return overview;
	}

	public String getMovieId() {
		return movieId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	
	public void setOverview(String overview) {
		this.overview = overview;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}
@JsonProperty("comments")
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
