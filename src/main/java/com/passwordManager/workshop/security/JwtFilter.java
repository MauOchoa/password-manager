package com.passwordManager.workshop.security;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

public class JwtFilter extends BasicAuthenticationFilter {
	
	private JwtTokenProvider jwtprov;
	
	
	public JwtFilter(JwtTokenProvider jwtprov, AuthenticationManager authenticationManager){
		super(authenticationManager);
		this.jwtprov = jwtprov;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		String token = request.getHeader("Authorization").substring(7);
		Boolean user = jwtprov.validateToken(token);
		if (user) {
			Authentication auth = new UsernamePasswordAuthenticationToken(jwtprov.extractUsername(request),new ArrayList<>());
			SecurityContextHolder.getContext().setAuthentication(auth);
		}
		filterChain.doFilter(request, response);
	}
	
}
