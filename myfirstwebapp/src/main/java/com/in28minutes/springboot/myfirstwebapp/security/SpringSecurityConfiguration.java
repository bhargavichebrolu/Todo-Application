package com.in28minutes.springboot.myfirstwebapp.security;

	
import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SpringSecurityConfiguration {
	//InMemoryUserDetailsManager
	@Bean
	public InMemoryUserDetailsManager createUserDeatailsManager() {
			
			UserDetails userDetails1 = createNewUser("in28minutes", "dummy");
			UserDetails userDetails2 = createNewUser("Bhargavi", "ammu");
			return new InMemoryUserDetailsManager(userDetails1,userDetails2);
	}
	private UserDetails createNewUser(String username, String password) {
		Function<String, String> passwordEncoder
		=input -> passwordEncoder().encode(input);
		UserDetails userDetails=User.builder().
				passwordEncoder(passwordEncoder).
				username(username).
				password(password).
				roles("USER","ADMIN")
				.build();
		return userDetails;
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	//All Urls are Protected
	//A login form is shown for unauthorised requests
	//CSRF disbale
	//Frames
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests(
				auth->auth.anyRequest().authenticated());
		http.formLogin(withDefaults());
		http.csrf().disable();
		http.headers().frameOptions().disable();
		return http.build();
		}
	
	
	
	
	
	
}