package com.steven.webappdemo1.todo;

import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class TodoTask {

    private int id;
    private String username;
    @Size(min = 10, message = "Please enter at least 10 characters")
    private String description;
    private LocalDate targetCompleteDate;
    private boolean done;

    public TodoTask(int id, String username, String description, LocalDate targetCompleteDate, boolean done) {
        this.id = id;
        this.username = username;
        this.description = description;
        this.targetCompleteDate = targetCompleteDate;
        this.done = done;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getTargetCompleteDate() {
        return targetCompleteDate;
    }

    public void setTargetCompleteDate(LocalDate targetCompleteDate) {
        this.targetCompleteDate = targetCompleteDate;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return "TodoTask{" +
               "id=" + id +
               ", username='" + username + '\'' +
               ", description='" + description + '\'' +
               ", targetCompleteDate=" + targetCompleteDate +
               ", done=" + done +
               '}';
    }
}
