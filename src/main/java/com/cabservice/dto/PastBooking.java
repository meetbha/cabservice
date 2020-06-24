package com.cabservice.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PastBooking {
	
	private String pickUpAddress;

	private String dropAddress;
	
	private Date date;

}
