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
}