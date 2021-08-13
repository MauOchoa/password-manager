package com.passwordManager.workshop.security;

import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;

public class FilterConfigurer extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

	private JwtTokenProvider jwtprov;
	
	public FilterConfigurer(JwtTokenProvider jwtprov){
		this.jwtprov = jwtprov;
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		JwtFilter jwtFilter = new JwtFilter(jwtprov, null);
		http.addFilterBefore(jwtFilter,null);
	}
	
	
}
