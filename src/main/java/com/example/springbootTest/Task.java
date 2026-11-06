package com.example.springbootTest;

public class Task {

    // フィールド
    private Long id;
    private String title;
    private boolean completed;

    // コンストラクタ
    public Task(Long id, String title, boolean completed) {
        this.id = id;
        this.title = title;
        this.completed = completed;
    }

    
    //id のGetter
    public Long getId() {
        return id;
    }

    //id のSetter
    public void setId(Long id) {
        this.id = id;
    }
    
    //title のGetter
    public String getTitle() {
        return title;
    }

    //title のSetter
    public void setTitle(String title) {
        this.title = title;
    }

    //completed のGetter
    public boolean isCompleted() {
        return completed;
    }

    //completed のSetter
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

}