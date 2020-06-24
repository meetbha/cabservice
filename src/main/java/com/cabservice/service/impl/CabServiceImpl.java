package com.cabservice.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cabservice.dto.CabDetails;
import com.cabservice.dto.CabRequest;
import com.cabservice.dto.PastBooking;
import com.cabservice.dto.TokenDto;
import com.cabservice.exception.CustomNotFoundException;
import com.cabservice.model.Booking;
import com.cabservice.model.Cab;
import com.cabservice.repository.BookingRepository;
import com.cabservice.repository.CabRepository;
import com.cabservice.service.CabService;

@Service
public class CabServiceImpl implements CabService {
	
	@Autowired
	CabRepository cabRepository;

	@Autowired
	BookingRepository bookingRepository;
	
	private Random rand = new Random(); 

	@Override
	public CabDetails bookCab(CabRequest cabRequest, TokenDto tokenDto) {
		List<Cab> cabList = cabRepository.findAllByLocation(cabRequest.getPickUpLocation());
		if(cabList != null && !cabList.isEmpty()) {
			Cab cab = cabList.get(rand.nextInt(cabList.size()));
			Booking booking = new Booking();
			BeanUtils.copyProperties(cabRequest, booking);
			booking.setCab(cab);
			booking.setUser(tokenDto.getUserName());
			booking.setName(tokenDto.getName());
			bookingRepository.save(booking);
			return new CabDetails(cab.getDriver(), cab.getCabNumber());
		} else {
			throw new CustomNotFoundException("No Cab Found!");
		}
		
	}

	@Override
	public List<PastBooking> viewPastBookings(TokenDto tokenDto) {
		List<Booking> bookings = bookingRepository.findAllByUser(tokenDto.getUserName());
		List<PastBooking> pastBookings = new ArrayList<>();
		if(bookings != null && !bookings.isEmpty()) {
			bookings.stream().forEach(booking -> {
				PastBooking pastBooking = new PastBooking();
				pastBooking.setPickUpAddress(booking.getPickUpAddress());
				pastBooking.setDropAddress(booking.getDropAddress());
				pastBooking.setDate(booking.getCreated());
				pastBookings.add(pastBooking);
			});
		} else {
			throw new CustomNotFoundException("No Previous Booking Found");
		}
		return pastBookings;
	}

}
