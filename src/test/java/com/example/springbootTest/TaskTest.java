package com.example.springbootTest;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;



@SpringBootTest
public class TaskTest {

	@Autowired
	private TaskService service;
	
    @Test
    void testAddTask() {

        Long taskId = service.addTask("掃除");

        Task task = service.findTaskById(taskId);

        assertNotNull(task);
        assertEquals("掃除", task.getTitle());

    }
    
    @Test
    void testUpdateTask() {

        Long taskId = service.addTask("Javaの勉強");

        service.updateTask(taskId, "Spring Bootの勉強", true);

        Task task = service.findTaskById(taskId);
        
        assertEquals("Spring Bootの勉強", task.getTitle());
        assertEquals(true, task.isCompleted());

    }
    
    @Test
    void testDeleteTask() {

        Long taskId = service.addTask("削除テスト");

        service.deleteTask(taskId);

        Task task = service.findTaskById(taskId);

        assertNull(task);

    }
    
    @Test
    void testUpdateTaskWithBlankTitle() {

        Long taskId = service.addTask("Javaの勉強");

        service.updateTask(taskId, "", true);

        Task task = service.findTaskById(taskId);
        
        assertEquals("Javaの勉強", task.getTitle());
        assertEquals(false, task.isCompleted());

    }
    
    @Test
    void testUpdateTaskNotFound() {
    	
    	assertThrows(TaskNotFoundException.class,() -> {
    		service.updateTask(999L, "新しいタスク", true);
    	});
    	
    }
    
    @Test
    void testDeleteTaskNotFound() {
    	
    	assertThrows(TaskNotFoundException.class, () -> {
    	    service.deleteTask(999L);
    	});
    	
    }
    
}