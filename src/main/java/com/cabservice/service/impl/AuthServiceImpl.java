package com.cabservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cabservice.dto.SignUpForm;
import com.cabservice.exception.CustomInvalidInputException;
import com.cabservice.model.User;
import com.cabservice.repository.UserRepository;
import com.cabservice.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	PasswordEncoder encoder;

	@Override
	public User registerUser(SignUpForm signUpRequest) {

		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			throw new CustomInvalidInputException("Username is already taken!");
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			throw new CustomInvalidInputException("Email is already in use!");
		}

		User user = new User(signUpRequest.getName(), signUpRequest.getUsername(), signUpRequest.getEmail(),
				encoder.encode(signUpRequest.getPassword()));

		return userRepository.save(user);

	}

}
