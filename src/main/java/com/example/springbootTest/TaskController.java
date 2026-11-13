package com.example.springbootTest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;

@Controller
public class TaskController {
	
	private final TaskService service;
	
	public TaskController(TaskService service) {
		
		this.service = service;
		
	}
	
	@GetMapping("/tasks")
	public String getTasks(Model model) {
        model.addAttribute("tasks",service.getAllTasks());
        return "tasks";
	}
	
	@PostMapping("/tasks")
	public String addTask(
			@Valid Task task,
			BindingResult result,
			Model model) {
				
		if(result.hasErrors()) {
			model.addAttribute("tasks", service.getAllTasks());
			model.addAttribute("errorMessage","タスク名を入力してください。");
			return "tasks";
		}
		
		service.addTask(task.getTitle());
		
		return "redirect:/tasks";
	}
	
	@PostMapping("/tasks/update")
	public String updateTask(
			@RequestParam Long id,
			@Valid Task task,
			BindingResult result,
			@RequestParam boolean completed,
			Model model) {
		
		if(result.hasErrors()) {
			
			model.addAttribute("tasks", service.getAllTasks());
			model.addAttribute("errorMessage", "タスク名を入力してください。");
			
			return "tasks";
		}
		
		service.updateTask(id, task.getTitle(), completed);
		return "redirect:/tasks";
	}

	@PostMapping("/tasks/delete")
	public String deleteTask(@RequestParam Long id) {
		
		service.deleteTask(id);
		
		return "redirect:/tasks";
		
	}
}
