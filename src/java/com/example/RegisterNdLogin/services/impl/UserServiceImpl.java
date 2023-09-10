package com.example.RegisterNdLogin.services.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.RegisterNdLogin.models.User;
import com.example.RegisterNdLogin.models.UserRole;
import com.example.RegisterNdLogin.repos.RoleRepository;
import com.example.RegisterNdLogin.repos.UserRepository;
import com.example.RegisterNdLogin.services.UserService;

@Service
public class UserServiceImpl implements UserService{
	//user and role ko save krenge
	@Autowired
	UserRepository userRepo;
	@Autowired
	RoleRepository roleRepo;

	//creating user
	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception {
		// TODO Auto-generated method stub
		//ek ek krke role ko nikalenge then save krenge
		User local=this.userRepo.findByUsername(user.getUsername());
		//check krenge ki user jo aa raha already DB mei hai ki nai
		if(local!=null)
		  {
		   System.out.print("user already exists!");
	 	   throw new Exception("user already exists in database!");//already exists
		  }
		else
		  {
		   //create user
		   for(UserRole ur:userRoles) {
		      roleRepo.save(ur.getRole());//sirf roles ko save kia
		   }
		   user.getUserRoles().addAll(userRoles);//assign krdiye saare roles to user,then save krenge
		   local=this.userRepo.save(user);
		  }
		return local;
	}

	//getting user by username
	@Override
	public User getUser(String username) {
		// TODO Auto-generated method stub
		return this.userRepo.findByUsername(username);
		//kuch data ni hoga toh null millega
	}
	
	//get all users
	@Override
	public List<User> getAllCare() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	//delete user by id
	@Override
	public void delUser(int uid) {
		// TODO Auto-generated method stub
		this.userRepo.deleteById(uid);
	}

	//update api
	@Override
	public User update(User user) {
		// TODO Auto-generated method stub
		return userRepo.save(user);
	}
}