package com.cabservice.dto;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CabRequest {
	
	@NotBlank
	private String pickUpLocation;
	
	@NotBlank
	private String pickUpAddress;
	
	@NotBlank
	private String dropAddress;

}
