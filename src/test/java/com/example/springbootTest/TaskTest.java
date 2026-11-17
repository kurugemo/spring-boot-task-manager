package com.example.springbootTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class TaskTest {

	@Autowired
	private TaskService service;
	
    @Test
    void testTaskCrud(){

    	
        // タスクを追加
    	service.addTask("Javaの勉強");
    	service.addTask("買い物");
    	Long taskId = service.addTask("掃除");

    	Task task = service.findTaskById(taskId);
    	assertNotNull(task);
    	assertEquals("掃除", task.getTitle());
        
        service.updateTask(taskId, "", true);
        task = service.findTaskById(taskId);
        assertEquals(false, task.isCompleted());
        
        System.out.println(task.getId() + ":" + task.getTitle() + ":" + task.isCompleted());
        
        service.updateTask(taskId, "Spring Bootの勉強", true);
        
        task = service.findTaskById(taskId);
        
        System.out.println(task.getId() + ":" + task.getTitle() + ":" + task.isCompleted());

        service.deleteTask(taskId);
        assertNull(service.findTaskById(taskId));
        
        System.out.println(service.findTaskById(taskId));
        
    }
    
    
    	
    
}