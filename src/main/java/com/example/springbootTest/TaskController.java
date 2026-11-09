package com.example.springbootTest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String addTask(@RequestParam String title) {
				
		service.addTask(title);
		
		return "redirect:/tasks";
	}
	
	@PostMapping("/tasks/update")
	public String updateTask(
			@RequestParam Long id,
			@RequestParam boolean completed) {
		
		Task task = service.findTaskById(id);
		
		service.updateTask(id, task.getTitle(), completed);
		
		return "redirect:/tasks";
	}

	@PostMapping("/tasks/delete")
	public String deleteTask(@RequestParam Long id) {
		
		service.deleteTask(id);
		
		return "redirect:/tasks";
		
	}
}
