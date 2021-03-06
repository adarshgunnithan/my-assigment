package com.cognizant.moviecruiser.auth.exception;

@SuppressWarnings("serial")
public class UserNotFoundException extends Exception {
	String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public UserNotFoundException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return "UserNotFoundException [message=" + message + "]";
	}
}