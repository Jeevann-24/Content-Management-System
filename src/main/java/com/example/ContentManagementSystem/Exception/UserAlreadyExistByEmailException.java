package com.example.ContentManagementSystem.Exception;

public class UserAlreadyExistByEmailException extends RuntimeException {
	
	private String message;
	
	 public UserAlreadyExistByEmailException(String message) {
		 this.message=message;
	 }
	 public String getMessage() {
		 return message;
	 }

}
