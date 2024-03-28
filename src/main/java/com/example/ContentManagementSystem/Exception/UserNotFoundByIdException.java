package com.example.ContentManagementSystem.Exception;

import lombok.Getter;
import lombok.Setter;


public class UserNotFoundByIdException extends RuntimeException{
	private String message;

	public UserNotFoundByIdException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
