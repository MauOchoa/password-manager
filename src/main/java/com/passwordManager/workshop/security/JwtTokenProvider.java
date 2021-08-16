package com.passwordManager.workshop.security;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Jwts;

@Component
public class JwtTokenProvider {
	
	private String SECRET_KEY = "Maurapids1234";
	
	public String extractUsername(HttpServletRequest httpRequest) {
		String token = httpRequest.getHeader("Authorization").substring(7);
		return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getSubject(); // returns User from headers
	}
	
	public String validateToken(String token){
		try{
			return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getSubject();
		}
		catch(Exception e) {
			return e.toString();
		}
		
		
	}
	
}
