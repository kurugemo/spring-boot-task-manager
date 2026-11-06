package com.example.springbootTest;

import java.util.List;

public class TaskTest {

    public static void main(String[] args) {

        // Repositoryを作成
        TaskRepository repository = new TaskRepository();

        // タスクを追加
        repository.addTask(new Task(1L, "Javaの勉強", false));
        repository.addTask(new Task(2L, "買い物", false));
        repository.addTask(new Task(3L, "掃除", true));

        // タスク一覧を取得
        List<Task> tasks = repository.getTasks();

        // タスクを1件ずつ表示
        for (Task task : tasks) {
            System.out.println(task.getTitle());
        }
        
        //IDが10のタスクを取得
        Task task = repository.findById(10L);

        // 取得できたか確認
        if (task != null) {
            System.out.println(task.getTitle());
        } else {
            System.out.println("タスクが見つかりません");
        }

    }

}