//!!! AS This Application is using a Database, THIS CLASS IS NOT IN USE !!!

package com.steven.webappdemo1.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

//@Service
public class TodoService {

    private static List<TodoTask> todoTasks = new ArrayList<>();

    private static int todoCount = 0;
    static {
        todoTasks.add(new TodoTask(++todoCount,"steven", "Learn JAVA", LocalDate.now().plusYears(1),false ));
        todoTasks.add(new TodoTask(++todoCount,"steven", "Find a new job", LocalDate.of(2023,3,1),false ));
        todoTasks.add(new TodoTask(++todoCount,"steven", "Go to grocery store", LocalDate.of(2023,2,2),false ));
    }

    public List<TodoTask> findByUsername(String username) {
        Predicate<? super TodoTask> predicate = todoTask -> todoTask.getUsername().equalsIgnoreCase(username);
        return todoTasks.stream().filter(predicate).toList();
    }

    public void addTodoTask(String username, String description, LocalDate targetCompleteDate, boolean done) {
        TodoTask todoTask = new TodoTask(++todoCount,username,description,targetCompleteDate,done);
        todoTasks.add(todoTask);
    }

    public void deleteTodoById(int id) {
        Predicate<? super TodoTask> predicate = todoTask -> todoTask.getId() == id;
        todoTasks.removeIf(predicate);
    }

    public TodoTask updateById(int id) {
        Predicate<? super TodoTask> predicate = todoTask -> todoTask.getId() == id;
        return todoTasks.stream().filter(predicate).findFirst().get();
    }


    public void updateTodo(TodoTask todoTask) {
        deleteTodoById(todoTask.getId());
        todoTasks.add(todoTask);
    }
}
