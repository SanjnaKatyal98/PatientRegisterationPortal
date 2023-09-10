package com.example.RegisterNdLogin;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.RegisterNdLogin.models.User;
import com.example.RegisterNdLogin.services.UserService;
import com.example.RegisterNdLogin.helper.UserFoundException;
import com.example.RegisterNdLogin.models.UserRole;
import com.example.RegisterNdLogin.models.Role;

@SpringBootApplication
public class RegisterNdLoginApplication implements CommandLineRunner{
	@Autowired
	private UserService userService;//spring security jb use krenge tb use hoga
	/*@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;*/

	public static void main(String[] args) {
		SpringApplication.run(RegisterNdLoginApplication.class, args);
	}
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://localhost:4200");
			}
		};
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("starting code");
		try {
			//user create kia
			User user=new User();
			user.setFullname("sanjna katyal");
			user.setUsername("sanj09");
			user.setPassword("shahid28");
			user.setAge(25);
			user.setGender("F");
	
			//role create kia
			Role role=new Role();
			role.setRoleId(1);
			role.setRname("ADMIN");
			
			//role set create kia
			Set<UserRole> userRoleSet=new HashSet<>();
			UserRole userRole=new UserRole();
			userRole.setRole(role);
			userRole.setUser(user);
			userRoleSet.add(userRole);
					
			User u=userService.createUser(user, userRoleSet);
			System.out.println(u.getUsername());
		}catch (UserFoundException e) {
            e.printStackTrace();
        }
		System.out.println("ending code");
	}
}