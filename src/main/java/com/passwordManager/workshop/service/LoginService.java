package com.passwordManager.workshop.service;

import com.passwordManager.workshop.models.LoginDetails;
import com.passwordManager.workshop.models.Tokens;

public interface LoginService {
	
	Tokens login(LoginDetails details) throws Exception;

}
