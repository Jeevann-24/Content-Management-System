package com.example.ContentManagementSystem.Utility;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.ContentManagementSystem.Exception.UserAlreadyExistByEmailException;

import lombok.AllArgsConstructor;

@RestControllerAdvice
public class ApplicationExceptionHandler {

	private ErrorStructure<String> structure;

	public ApplicationExceptionHandler(ErrorStructure structure) {
		super();
		this.structure = structure;
	}
	  
	private ResponseEntity<ErrorStructure<String>> errorResponse(HttpStatus status,String message, String rootCause){
		
		return new ResponseEntity<ErrorStructure<String>>(structure.
				setStatusCode(status.value())
				.setErrorMessage(message)
				.setRootCause(rootCause),status);
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> handleUserAlreadyExistByEmail(UserAlreadyExistByEmailException ex){
		return errorResponse(HttpStatus.BAD_REQUEST, ex.getMessage(),"User already exists with the given gamil");
	}
		
	
}

