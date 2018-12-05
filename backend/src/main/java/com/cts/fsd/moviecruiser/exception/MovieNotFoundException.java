package com.cts.fsd.moviecruiser.exception;

/**
 * @author Adarsh
 *Business Exception ,if movie is not found in db
 */
public class MovieNotFoundException extends Exception{
	String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public MovieNotFoundException(String message) {
		super(message);
		this.message = message;
	}

	@Override
	public String toString() {
		return "MovieNotFoundException [message=" + message + "]";
	}
}
