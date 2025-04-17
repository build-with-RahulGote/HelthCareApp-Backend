package com.techhub.hms.Models;

import lombok.Data;

@Data
public class LoginRequest {
	 private String username;
	    private String password;
	    private String role;
}
