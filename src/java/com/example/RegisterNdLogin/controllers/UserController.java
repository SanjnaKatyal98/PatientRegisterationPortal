package com.example.RegisterNdLogin.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.RegisterNdLogin.services.UserService;
import com.example.RegisterNdLogin.helper.UserFoundException;
import com.example.RegisterNdLogin.models.Role;
import com.example.RegisterNdLogin.models.User;
import com.example.RegisterNdLogin.models.UserRole;

@RestController
@RequestMapping("/user") //iss controller ko access krne ke liye postman mei yeh likhna padega	
@CrossOrigin("*") //isska mtlb angular ke port nd isske port mei issue nai aayega,cz dono ke ports alag hai;* mtlb saare host allow kr diye
public class UserController {
	//yaha saare end pts honge humare[website mei]
	//creating user
	@Autowired
	private UserService userService;
	/*@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;*/
	
	//for angular
	//create user
	@PostMapping("/")
	public User createUser(@RequestBody User user) throws Exception {
		Set<UserRole> roles=new HashSet<>();
		Role r=new Role();
		r.setRoleId(2);	
		r.setRname("NORMAL");//user role specified
		UserRole userRole=new UserRole();
		userRole.setRole(r);
		userRole.setUser(user);//user jo register kia
		roles.add(userRole);
		return this.userService.createUser(user, roles);
	}
			
	//fetching user
	@GetMapping("/{username}")
	public User getUser(@PathVariable("username") String username) {
		return this.userService.getUser(username);
	}
			
	//deleting user
	@DeleteMapping("/{uid}")
	public void delUser(@PathVariable("uid") int uid) {
		this.userService.delUser(uid);
	}
	
	@GetMapping("/all")
    public ResponseEntity<List<User>> getAllCare() {
        List<User> allCare = userService.getAllCare();
        return ResponseEntity.ok(allCare);
    }
	
	//update api
	@PutMapping("/update")
	public User update(User u){
		return userService.update(u);
	}
	
	@ExceptionHandler(UserFoundException.class)
    public ResponseEntity<?> exceptionHandler(UserFoundException ex) {
        return ResponseEntity.ok(ex.getMessage());
    }
}