package com.passwordManager.workshop.service.Impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.passwordManager.workshop.models.LoginDetails;
import com.passwordManager.workshop.models.Tokens;
import com.passwordManager.workshop.security.JwtTokenProvider;
import com.passwordManager.workshop.service.LoginService;
import com.passwordManager.workshop.service.UserDataService;

@Service
public class LoginServiceImpl implements LoginService{

	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	@Autowired
	JwtTokenProvider jwtTokenProvider;
	
	@Autowired
	UserDataService userDataService;
	
	@Override
    public Tokens login(LoginDetails details) throws Exception {
		
		String dbPassword = userDataService.readUserByUserName(details.getUser()).getPassword();
		
		if (!passwordEncoder.matches(details.getPassword(), dbPassword)){
	           throw new Exception("Login failed");
	    }
		
		Tokens tokens = new Tokens();
		tokens.setAccesToken(jwtTokenProvider.createToken(details.getUser()));
		tokens.setRefreshToken(jwtTokenProvider.createRefreshToken(details.getUser()));
		return tokens;
		
       /*System.out.println(details.getPassword()+ " before encode");
       String dao= daoData(details.getPassword());
       System.out.println(dao+ " after encode");*/
		/*
       String dbPassword= userDataService.readUserByUserName(details.getUser()).getPassword();
       
       Tokens tokens= new Tokens();
       tokens.setAccessToken(jwtTokenProvider.createToken(details.getUser()));
       tokens.setRefreshToken(jwtTokenProvider.createRefreshToken(details.getUser()));
       return tokens;*/ 
    }
	
	//This is a mock
	public String daoData(String password){
		return passwordEncoder.encode(password);
	}
	
	/*public Tokens refreshTokens(HttpServletRequest httpRequest){
        
       String token = httpRequest.getHeader("Authorization").substring(7);
       jwtTokenProvider.extractUsername(httpRequest); // ver que exista en db
       //checar que tenga el scope de refresh  userDataService.readUserByUserName(userName)
       //
       
       Tokens tokens= new Tokens();
       tokens.setAccessToken(jwtTokenProvider.createToken(details.getUser()));
       tokens.setRefreshToken(jwtTokenProvider.createRefreshToken(details.getUser()));
       return tokens; 
    }*/
	

}
