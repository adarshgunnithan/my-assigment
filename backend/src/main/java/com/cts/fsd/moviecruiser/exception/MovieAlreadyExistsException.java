package com.cts.fsd.moviecruiser.exception;

/**
 * @author Adarsh
 * Business Exception , if movie already exists in db
 */
public class MovieAlreadyExistsException extends Exception{
	String message;

	public String getMessage() {
		return message;
	}

	public MovieAlreadyExistsException(String message) {
		super(message);
		this.message = message;
	}

	@Override
	public String toString() {
		return "MovieAlreadyExistsException [message=" + message + "]";
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
