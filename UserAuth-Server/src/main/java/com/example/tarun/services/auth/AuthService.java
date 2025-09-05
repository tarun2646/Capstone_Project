package com.example.tarun.services.auth;

import com.example.tarun.dto.SignupRequest;
import com.example.tarun.dto.UserDto;

public interface AuthService 
{

	UserDto signupUser(SignupRequest signupRequest);
	boolean hasUserWithEmail(String email);
}
