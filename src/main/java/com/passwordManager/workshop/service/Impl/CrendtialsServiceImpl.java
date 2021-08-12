package com.passwordManager.workshop.service.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.passwordManager.workshop.models.Credentials;
import com.passwordManager.workshop.repository.CredentialsRepository;
import com.passwordManager.workshop.service.CredentialsService;

@Service
public class CrendtialsServiceImpl implements CredentialsService {

	@Autowired
	CredentialsRepository credRepository;
	
	public List<Credentials> getCredentials(String domain, String user){
		return credRepository.findByDomainAndUser(domain, user);
	}
	
}
