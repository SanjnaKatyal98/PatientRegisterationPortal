package com.example.RegisterNdLogin.config;

import com.example.RegisterNdLogin.services.impl.UserDetailsServiceImpl;
import com.example.RegisterNdLogin.config.JwtAuthenticationEntryPoint;
import com.example.RegisterNdLogin.config.JwtAuthenticationFilter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.nio.file.Path;
import java.nio.file.Paths;

@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@SuppressWarnings("deprecation")
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
    private JwtAuthenticationEntryPoint unauthorizedHandler;
    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;
    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;
    
    @Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	/*
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();//secure
	}
	*/
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();//not secure;only for testing purpose
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//jbhi yeh authentication krega toh issi user detail service ka load user by username method call krega
		auth.userDetailsService(this.userDetailsServiceImpl).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//kaunse end pt public krna ya use krna yaha yeh hoga
		http
		       .csrf() 
			   .disable() 
			   .cors()
		       .disable()
		       .authorizeRequests()
		       .antMatchers("/generate-token","/user/").permitAll()
			   .antMatchers(HttpMethod.OPTIONS).permitAll()
			   .anyRequest().authenticated()
			   .and()
			   .exceptionHandling().authenticationEntryPoint(unauthorizedHandler)
			   .and()
			   .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
		
		/*csrf-> cross site req forgery ko disable kra
		  cors-> cross-origin resource sharing disable kia
		  authreq-> user ki req ko krenge auth
		  antmatcher-> 1 req jisspe token generate ho nd 2 user reg ke liye oosko permit all krenge
		  antmatcher-> jitne bhi options vale method hai oosko
		  anyreq-> baki req ko authenticate krna hoga
		  except-> jb koi prob ya error ho
		  sessionmngmnt-> bassically session creation policy ko stateless kia hai
		  fiterbefore-> jbhi bhi req aayega hrr baar authenticate krna hoga ki valid token hai nd oosko filter krke forward krenge.*/
	}
}