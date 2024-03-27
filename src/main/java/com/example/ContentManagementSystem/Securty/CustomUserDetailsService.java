package com.example.ContentManagementSystem.Securty;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.ContentManagementSystem.Entity.User;
import com.example.ContentManagementSystem.Exception.UserNameNotFoundException;
import com.example.ContentManagementSystem.Repository.UserRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService{

	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userRepository.findByEmail(username)
				             .map(user-> new CustomUserDetails(user))
				             .orElseThrow(()->new UserNameNotFoundException("User-Name Not Found"));
	}

}
