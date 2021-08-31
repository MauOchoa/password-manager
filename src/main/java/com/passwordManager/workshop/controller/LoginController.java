package com.passwordManager.workshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.passwordManager.workshop.models.LoginDetails;
import com.passwordManager.workshop.service.LoginService;

@RestController
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@PostMapping(value="/login")
	public ResponseEntity<?> login(@RequestBody LoginDetails details) throws Exception{
		try {
			String l = loginService.login(details);
			return new ResponseEntity<String>(l, HttpStatus.ACCEPTED);
		} catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
	}
	
}
