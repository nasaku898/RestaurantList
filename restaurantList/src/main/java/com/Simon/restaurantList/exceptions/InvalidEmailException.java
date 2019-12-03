package com.Simon.restaurantList.exceptions;

public class InvalidEmailException extends Exception {

	public InvalidEmailException() {
		super("Invalid Email");
	}

	public InvalidEmailException(String message) {
		super(message);
	}
}
