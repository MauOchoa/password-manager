package com.passwordManager.workshop.models;

import lombok.Data;

@Data
public class LoginDetails {
	
	private String user;
	private String password;
	
	@Override
	public String toString() {
		return "loginDetails [password= " + password + ", user= " + user + "]";
	}

}
