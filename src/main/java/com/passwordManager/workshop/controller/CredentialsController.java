package com.passwordManager.workshop.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import com.passwordManager.workshop.models.Credentials;
import com.passwordManager.workshop.security.JwtTokenProvider;
import com.passwordManager.workshop.service.CredentialsService;




@RestController
public class CredentialsController {
	
	
	@Autowired
	JwtTokenProvider jwt;
	
	@Autowired
	CredentialsService credService;
	
	
	@GetMapping(value="/get/{domain}")
	public List<Credentials> getPassword(@PathVariable("domain")String domain, HttpServletRequest request) {
		String user = jwt.extractUsername(request);
		return credService.getCredentials(domain, user);	 
	}
	
	@GetMapping(value="/get/hello")
	public String helloWorld(){
		return "Hello World!";
	}
	
	
	@PostMapping(value="/post")
	public String postPassword() {
		return null;
	}
	
	@DeleteMapping(value="/delete")
	public String deletePassword() {
		return null;
	}
	
	@PutMapping(value="/put")
	public String putPassword() {
		return null;
	}
	
}
