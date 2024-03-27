package com.example.ContentManagementSystem.Service;

import org.springframework.http.ResponseEntity; 

import com.example.ContentManagementSystem.UserDTO.UserRequestDTO;
import com.example.ContentManagementSystem.UserDTO.UserResponseDTO;
import com.example.ContentManagementSystem.Utility.ResponseStructure;


public interface UserService {

	ResponseEntity<ResponseStructure<UserResponseDTO>> registerUser(UserRequestDTO userreq);

	

	
}
