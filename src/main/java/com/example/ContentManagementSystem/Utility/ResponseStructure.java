package com.example.ContentManagementSystem.Utility;

import org.springframework.stereotype.Component;

@Component
public class ResponseStructure<T> {
	
	private int statusCode;
	private String message;
	private T data;
	public ResponseStructure<T> setStatusCode(int statusCode) {
		this.statusCode = statusCode;
		return this;
	}
	public ResponseStructure<T> setMessage(String message) {
		this.message = message;
		return this;
	}
	public ResponseStructure<T> setData(T data) {
		this.data = data;
		return this;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public String getMessage() {
		return message;
	}
	public T getData() {
		return data;
	}
	
}
