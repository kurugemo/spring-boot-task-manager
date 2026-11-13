package com.example.springbootTest;

public class TaskNotFoundException extends RuntimeException {
	
	public TaskNotFoundException(String message) {
		super(message);
	}

}
