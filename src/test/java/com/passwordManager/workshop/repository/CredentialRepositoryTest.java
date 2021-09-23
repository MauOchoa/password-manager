package com.passwordManager.workshop.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.passwordManager.workshop.models.Credentials;

@DataJpaTest
public class CredentialRepositoryTest {

	@Autowired
	CredentialsRepository credRepository;
	
	@Test
	public void testFindByDomainAndIdUserAndUser() {
		Credentials credentials = new Credentials(2,2,"Mau", "face", "1234");
		credRepository.save(credentials);
		Credentials catchedCred = credRepository.findByDomainAndIdUserAndUser("face", 2, "Mau");
		assertNotNull(catchedCred);
		assertEquals(catchedCred.getIdPass(), 2);
	}
	
}
