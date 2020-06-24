package com.cabservice.service;

import java.util.List;

import com.cabservice.dto.CabDetails;
import com.cabservice.dto.CabRequest;
import com.cabservice.dto.PastBooking;
import com.cabservice.dto.TokenDto;

public interface CabService {
	
	public CabDetails bookCab(CabRequest cabRequest, TokenDto tokenDto);
	
	public List<PastBooking> viewPastBookings(TokenDto tokenDto);

}
