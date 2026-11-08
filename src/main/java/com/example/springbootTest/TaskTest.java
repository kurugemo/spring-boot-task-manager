package com.example.springbootTest;

import java.util.List;

public class TaskTest {

    public static void main(String[] args) {

    	TaskRepository repository = new TaskRepository();
    	TaskService service = new TaskService(repository);

        // タスクを追加
        repository.addTask(new Task(1L, "Javaの勉強", false));
        repository.addTask(new Task(2L, "買い物", false));
        repository.addTask(new Task(3L, "掃除", true));

        Task task = service.findTaskById(3L);
        
        System.out.println(task.getId() + ":" + task.getTitle() + ":" + task.isCompleted());
        
        task = service.findTaskById(4L);
       
        System.out.println(task.getId() + ":" + task.getTitle() + ":" + task.isCompleted());

        
        
    }
    
    
    
    
}