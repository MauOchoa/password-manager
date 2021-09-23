package com.passwordManager.workshop.service;

import java.util.List;
import com.passwordManager.workshop.models.UserData;

public interface UserDataService {
	
	UserData createUser(UserData user);
	List <UserData> readAllUsers(UserData user);
	UserData readUserById(int userId);
	UserData readUserByUserName(String userName);
	UserData updateUser(UserData user);
	void deleteUser(int userId);
	
	

}
