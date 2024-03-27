package com.example.ContentManagementSystem.Securty;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.example.ContentManagementSystem.Entity.User;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CustomUserDetails implements UserDetails {
	
	private User user;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO 
		return null;
	}

	@Override
	public String getPassword() {
		// TODO return password from user reference of User Entity
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO return userName from user reference of User Entity
		return user.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Provide true here
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Provide true here 
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Provide True here also
		return true;
	}

	@Override
	public boolean isEnabled() {
		// We have to return true in isEnabled
		return true;
	}

}
