package com.passwordManager.workshop.service;

import java.util.List;
import com.passwordManager.workshop.models.Credentials;


public interface CredentialsService {

	List<Credentials> getCredentials (String domain, String user);
	
}
