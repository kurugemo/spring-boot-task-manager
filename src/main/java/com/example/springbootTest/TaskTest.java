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

        // IDが2のタスクを取得
        Task task = repository.findById(2L);

        // 取得できたか確認
        if (task != null) {
            System.out.println(task.getTitle());
        } else {
            System.out.println("タスクが見つかりません");
        }

        // IDが2のタスクを更新
        repository.updateTask(2L, "Spring Bootの勉強", true);

        // 更新後のタスクを取得
        Task updatedTask = repository.findById(2L);

        // 更新結果を表示
        System.out.println("更新後のタイトル：" + updatedTask.getTitle());
        System.out.println("完了状態：" + updatedTask.isCompleted());

        // IDが2のタスクを削除
        repository.deleteTask(2L);

        // 削除後の一覧を取得
        List<Task> remainingTasks = repository.getTasks();

        // 削除後の一覧を表示
        System.out.println("削除後のタスク一覧");

        for (Task remainingTask : remainingTasks) {
            System.out.println(
                remainingTask.getId() + "：" + remainingTask.getTitle()
            );
        }
        
    }
    
    
    
    
}