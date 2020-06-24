package com.cabservice.service;

import com.cabservice.dto.SignUpForm;
import com.cabservice.model.User;

public interface AuthService {
	
	public User registerUser(SignUpForm signUpRequest);

}
