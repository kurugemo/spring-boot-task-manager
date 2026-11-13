package com.example.springbootTest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.ui.Model;


@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(TaskNotFoundException.class)
	public String handleTaskNotFound(TaskNotFoundException e, Model model) {
		
		model.addAttribute("errorMessage", e.getMessage());
		
		return "error";
	}
}
