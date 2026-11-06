package com.example.springbootTest;

import java.util.ArrayList;
import java.util.List;

public class TaskRepository {
	
	private List<Task> tasks = new ArrayList<>();
	
	
	//タスクを追加するメソッド
    public void addTask(Task task) {
        tasks.add(task);
    }
    
    //タスクを取得して一覧表示するメソッド
    public List<Task> getTasks() {
        return tasks;
    }
    
    //IDからタスクを1件取得するメソッド
    public Task findById(Long id) {

        for (Task task : tasks) {

            if (task.getId().equals(id)) {
                return task;
            }
            
            

        }

        return null;
    }
    
    // タスクを更新するメソッド
    public void updateTask(Long id, String title, boolean completed) {

        Task task = findById(id);

        if (task != null) {
            task.setTitle(title);
            task.setCompleted(completed);
        }


    }
    
    // タスクを削除するメソッド
    public void deleteTask(Long id) {

        Task task = findById(id);

        if (task != null) {
            tasks.remove(task);
        }

    }
    
}