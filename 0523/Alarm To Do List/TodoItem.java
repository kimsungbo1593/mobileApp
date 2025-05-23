package com.example.mission2todo;

public class TodoItem {
    private int id;
    private String task;
    private boolean isCompleted;


    // 알림 기능
    private long alarmTime; // ← 추가
    
    // 생성자
    public TodoItem(int id, String task, boolean isCompleted, long alarmTime) {
        this.id = id;
        this.task = task;
        this.isCompleted = isCompleted;
        this.alarmTime = alarmTime;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }


    // 알림 추가
    public long getAlarmTime() {
        return alarmTime;
    }
    public void setAlarmTime(long alarmTime) {
        this.alarmTime = alarmTime;
    }
}

