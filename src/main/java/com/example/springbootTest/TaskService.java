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
		return repository.getTasks();
	}
	
	//入力されたタスクのタイトルが空欄でないか確認するService
	public void addTask(String title) {
	
		if(title.isBlank()) {
			return;
		}
		
		Long nextId = repository.getNextId();
		
		Task task = new Task(nextId, title, false);
		
		repository.addTask(task);
	}
	
	public Task findTaskById(Long id) {
		
		Task task = repository.findById(id);
		
		if(task == null) {
			return null;
		}
		
		return task;
	}
	
	public void updateTask(Long id, String title, boolean completed) {
		
		if(title.isBlank()) {
			return;
		}
		
		repository.updateTask(id, title, completed);
	}
	
	public void deleteTask(Long id) {
		
		repository.deleteTask(id);
		
	}
	
}