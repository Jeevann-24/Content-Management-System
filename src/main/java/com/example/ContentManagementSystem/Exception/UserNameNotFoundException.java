package com.example.ContentManagementSystem.Exception;

public class UserNameNotFoundException extends RuntimeException{

	private String message;
	
	 public UserNameNotFoundException(String message) {
		 this.message=message;
	 }
	 public String getMessage() {
		 return message;
	 }

}
