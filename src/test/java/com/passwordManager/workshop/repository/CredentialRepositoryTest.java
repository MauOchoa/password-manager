package com.passwordManager.workshop.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.passwordManager.workshop.models.Credentials;
import com.passwordManager.workshop.models.UserData;

@DataJpaTest
public class CredentialRepositoryTest {

	@Autowired
	CredentialsRepository credRepository;
	
	@Autowired
	UserDataRepository userDataRepository;
	
	@Test
	public void testFindByDomainAndIdUserAndUser() {
		UserData user = new UserData();
		user.setUserName("Mau");
		user.setPassword("something");
		user.setId(1);
		userDataRepository.save(user);
		
		Credentials credentials = new Credentials(1,1,"Mau", "face", "something");
		credRepository.save(credentials);
		Credentials catchedCred = credRepository.findByDomainAndIdUserAndUser("face", 1, "Mau");
		assertNotNull(catchedCred);
		assertEquals(catchedCred.getIdUser(), 1);
		assertEquals(catchedCred.getIdPass(),2);
	}
	
}
