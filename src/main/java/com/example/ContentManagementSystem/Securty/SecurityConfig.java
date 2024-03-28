package com.example.ContentManagementSystem.Securty;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import lombok.AllArgsConstructor;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {

	private CustomUserDetailsService userDetailService;

	@Bean
	AuthenticationProvider authenticationProvider() { // For DataBase Authentication 
		DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
		provider.setPasswordEncoder(passwordecoder());
		provider.setUserDetailsService(userDetailService);
		return provider;
	}

	@Bean
	PasswordEncoder passwordecoder() {
		return new BCryptPasswordEncoder(12);//How many times we need to validate minimum 4 , 12 ideal
	}

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity httpsecurity) throws Exception {
	return httpsecurity.csrf(csrf-> csrf.disable())         // CSRF -> Cross Site Request Forgery.
			           .authorizeHttpRequests(auth->auth    // We take the request
			           .requestMatchers("/users/register","/users/{userId}") // Checks with our URL Endpoint 
			           .permitAll()                         // allows /users/register
			           .anyRequest()                         
			           .authenticated())                    // any other URL it will authenticate 
			           .formLogin(Customizer.withDefaults())// And provide form login for user
			           .build();

	}
	
	
	

}

