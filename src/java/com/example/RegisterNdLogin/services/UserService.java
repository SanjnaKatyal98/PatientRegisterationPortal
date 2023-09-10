package com.example.RegisterNdLogin.services;

import java.util.List;
import java.util.Set;

import com.example.RegisterNdLogin.models.User;
import com.example.RegisterNdLogin.models.UserRole;

public interface UserService {
	/*DB mei cheeze save krne ke liye
	  loose coupling ki yaha
	  kitne roles mille user ko*/	
	
	//creating user
	public User createUser(User user,Set<UserRole> userRoles) throws Exception;
				
	//get user by username
	public User getUser(String username);
				
	//get all user
    List<User> getAllCare();
	    
	//delete user by id
	public void delUser(int uid);
		
	//update api
	public User update(User user);
}