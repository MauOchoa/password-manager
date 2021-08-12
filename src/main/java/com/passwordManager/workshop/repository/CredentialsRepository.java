package com.passwordManager.workshop.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.passwordManager.workshop.models.Credentials;

@Repository
public interface CredentialsRepository extends JpaRepository <Credentials, Integer>{

	List<Credentials> findByidUser(int idUser);
	
	List<Credentials> findByDomainAndUser(String domain, String user);
	
	Credentials findByDomainAndIdUserAndUser(String domain, int idUser, String user);
	
}
