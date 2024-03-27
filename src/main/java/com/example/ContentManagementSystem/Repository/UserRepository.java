package com.example.ContentManagementSystem.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository;

import com.example.ContentManagementSystem.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	public boolean existsByEmail(String userEmail);

	public Optional<User> findByEmail(String email);
	
	

	

}
