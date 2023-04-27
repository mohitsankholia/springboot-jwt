package com.mohit.spring_jwt.exceptions;

public class CustomExceptions extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}

	public CustomExceptions(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}

}
