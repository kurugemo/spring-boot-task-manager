package com.example.springbootTest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.ui.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@ControllerAdvice
public class GlobalExceptionHandler {
	
	private static final Logger logger =
			LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(TaskNotFoundException.class)
	public String handleTaskNotFound(TaskNotFoundException e, Model model) {
		
		logger.error("タスクが見つかりませんでした。", e);
		model.addAttribute("errorMessage", e.getMessage());
		
		return "error";
	}
}
