package com.example.ContentManagementSystem.Controller;

import org.springframework.http.ResponseEntity; 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ContentManagementSystem.Service.UserService;
import com.example.ContentManagementSystem.UserDTO.UserRequestDTO;
import com.example.ContentManagementSystem.UserDTO.UserResponseDTO;
import com.example.ContentManagementSystem.Utility.ResponseStructure;

import jakarta.validation.Valid;

@RestController
public class UserController {
	
	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@PostMapping("/users/register")
	public ResponseEntity<ResponseStructure<UserResponseDTO>> registerUser(@org.springframework.web.bind.annotation.RequestBody @Valid UserRequestDTO userreq){
		return userService.registerUser(userreq);
		
	}
	@GetMapping("testing")
	public String test() {
		return "Hello From Vyrat Kooli";
		
	}
}
