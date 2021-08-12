package com.passwordManager.workshop.security;

import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class FilterConfigurer extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

	private JwtTokenProvider jwtprov;
	
	public FilterConfigurer(JwtTokenProvider jwtprov){
		this.jwtprov = jwtprov;
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		JwtFilter jwtFilter = new JwtFilter(jwtprov);
		http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
	}
	
	
}
