package com.cabservice.exception;

public class CustomNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public CustomNotFoundException(String exception) {
		    super(exception);
	  }
}
