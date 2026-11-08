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

        repository.deleteTask(2L);
        
        service.addTask("筋トレ");
        
        repository.deleteTask(4L);
        
        service.addTask("ランニング");
        
        for (Task task : repository.getTasks()) {
            System.out.println(task.getId() + "：" + task.getTitle());
        }
        
        
    }
    
    
    
    
}