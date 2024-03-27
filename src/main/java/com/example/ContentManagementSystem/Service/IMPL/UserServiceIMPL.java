package com.example.ContentManagementSystem.Service.IMPL;
import org.springframework.http.HttpStatus; 
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.ContentManagementSystem.Entity.User;
import com.example.ContentManagementSystem.Exception.UserAlreadyExistByEmailException;
import com.example.ContentManagementSystem.Repository.UserRepository;
import com.example.ContentManagementSystem.Service.UserService;
import com.example.ContentManagementSystem.UserDTO.UserRequestDTO;
import com.example.ContentManagementSystem.UserDTO.UserResponseDTO;
import com.example.ContentManagementSystem.Utility.ResponseStructure;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class UserServiceIMPL implements UserService{

	private UserRepository userRepository;
	private ResponseStructure<UserResponseDTO> structure;
	private PasswordEncoder passwordEncoder;
	
	
//	public UserServiceIMPL(UserRepository userRepository, ResponseStructure<User> structure) {
//		super();
//		this.userRepository = userRepository;
//		this.structure = structure;
//	}
	
	@Override
	public ResponseEntity<ResponseStructure<UserResponseDTO>> registerUser(UserRequestDTO userreq) {
	
		if(userRepository.existsByEmail(userreq.getEmail())) 
			throw new UserAlreadyExistByEmailException("Failed to register user");
		User user=userRepository.save(mapUserEntity(userreq, new User()));
		
		return ResponseEntity.ok(structure.setStatusCode(HttpStatus.OK.value())
				.setMessage("Registered is done")
				.setData(mapToUserResponse(user)));
		
		
	}
	private User mapUserEntity(UserRequestDTO userreq, User user) {
		user.setEmail(userreq.getEmail());
		user.setPassword(passwordEncoder.encode(userreq.getPassword()));  //We are Encoding Password here
		user.setUserName(userreq.getUserName());
		return user;
	}
	   
	private UserResponseDTO mapToUserResponse(User user) {
		return UserResponseDTO.builder()	
			    .userId(user.getUserId())
			    .userName(user.getUserName())
			    .email(user.getEmail())
			    .build();
	}
}
