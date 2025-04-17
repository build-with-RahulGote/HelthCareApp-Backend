package com.techhub.hms.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.techhub.hms.Models.LoginRequest;
import com.techhub.hms.Services.loginServiceImpl;

@RestController
@CrossOrigin(origins = "*")
public class LoginController {
	@Autowired
	private loginServiceImpl loginService;

	
	 @PostMapping("/login")
	    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
	        try {
	            Object user = loginService.loginUser(loginRequest);
	            return ResponseEntity.ok(user);
	        } catch (RuntimeException e) {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
	        }
	    }
}
