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

}
