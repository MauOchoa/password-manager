package com.passwordManager.workshop.security;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenProvider {
	
	private String SECRET_KEY = "Maurapids1234";
	
	//@Value("${}")
	private long expTime = 900000;
	
	public String extractUsername(HttpServletRequest httpRequest) {
		String token = httpRequest.getHeader("Authorization").substring(7);
		return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getSubject(); // returns User from headers
	}
	
	public Boolean validateToken(String token){
		try{
			Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
		}
		catch(Exception e) {
			e.toString();
			return false;
		}
		return true;
		
	}
	
	public String createToken(String username) {
		Claims claims = Jwts.claims().setSubject(username);
		Date now = new Date();
		return Jwts.builder().setIssuer("maucar@hotmail.es").setClaims(claims).setIssuedAt(now)
		.setExpiration(new Date(now.getTime() + expTime))
		.signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
	}
	
	
	/*public List<String> getScopes(String Token){
		try {
			return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(Token).getBody().get("scopes", List.class);
		}
		
	}*/
	
}
