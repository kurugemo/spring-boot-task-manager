package com.example.springbootTest;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TaskService {
	
	private final TaskRepository repository;

	public TaskService(TaskRepository repository) {
	    this.repository = repository;
	}
	
	public List<Task> getAllTasks() {
		return repository.findAll();
	}
	
	public void addTask(String title) {
	
		if(title.isBlank()) {
			return;
		}
		
		Task task = new Task(null, title, false);
		
		repository.save(task);
	}
	
	public Task findTaskById(Long id) {
		
		return repository.findById(id).orElse(null);
		
	}
	
	public void updateTask(Long id, String title, boolean completed) {
		
		if(title.isBlank()) {
			return;
		}
		
		Task task = repository.findById(id).orElse(null);
		
		if(task == null) {
			
			throw new TaskNotFoundException("タスクが見つかりません。");
			
		}
		
		task.setTitle(title);
		task.setCompleted(completed);
		
		repository.save(task);
	
	}
	
	public void deleteTask(Long id) {
		
		repository.deleteById(id);
		
	}
	
}