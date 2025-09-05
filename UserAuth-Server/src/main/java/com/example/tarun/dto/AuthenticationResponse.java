package com.example.tarun.dto;


import com.example.tarun.enums.UserRole;

import lombok.Data;

@Data
public class AuthenticationResponse {
	
	private String jwt;
	private Long userId;
	private UserRole userRole;
	//private String profession; 

}
