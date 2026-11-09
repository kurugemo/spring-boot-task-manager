package com.example.springbootTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TaskTest {

	@Autowired
	private TaskService service;
	
    @Test
    void testTaskCrud(){

    	
        // タスクを追加
    	service.addTask("Javaの勉強");
    	service.addTask("買い物");
    	service.addTask("掃除");

        Task task = service.findTaskById(3L);
        
        System.out.println(task.getId() + ":" + task.getTitle() + ":" + task.isCompleted());
        
        service.updateTask(3L, "", true);
        
        System.out.println(task.getId() + ":" + task.getTitle() + ":" + task.isCompleted());
        
        service.updateTask(3L, "Spring Bootの勉強", true);
        
        task = service.findTaskById(3L);
        
        System.out.println(task.getId() + ":" + task.getTitle() + ":" + task.isCompleted());

        service.deleteTask(3L);
        
        System.out.println(service.findTaskById(3L));
        
    }
    
    
    	
    
}