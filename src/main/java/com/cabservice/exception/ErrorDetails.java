package com.cabservice.exception;

import java.util.Date;

public class ErrorDetails {
	private Date timestamp;
	private String message;

	public ErrorDetails(Date timestamp, String message) {
		super();
		this.timestamp = timestamp;
		this.message = message;
	}
	
	public ErrorDetails() {
		
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

}
