package com.passwordManager.workshop.service;

import com.passwordManager.workshop.models.LoginDetails;

public interface LoginService {
	
	String login(LoginDetails details) throws Exception;

}
