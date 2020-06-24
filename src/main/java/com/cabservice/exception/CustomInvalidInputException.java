package com.cabservice.exception;

public class CustomInvalidInputException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public CustomInvalidInputException(String exception) {
		super(exception);
	}
}
