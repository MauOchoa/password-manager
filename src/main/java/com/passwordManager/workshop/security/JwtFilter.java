package com.passwordManager.workshop.security;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Jwts;

public class JwtFilter extends OncePerRequestFilter {
	
	private JwtTokenProvider jwtprov;
	
	
	public JwtFilter(JwtTokenProvider jwtprov){
		this.jwtprov = jwtprov;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		String token = request.getHeader("Authorization").substring(7);
		String user = jwtprov.validateToken(token);
		if (user != null) {
			Authentication auth = new UsernamePasswordAuthenticationToken(user,null);
			SecurityContextHolder.getContext().setAuthentication(auth);
		}
		filterChain.doFilter(request, response);
	}
	
}
