package com.steven.webappdemo1.todo;

import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("name")
public class TodoControllerJpa {

    public TodoControllerJpa(TodoTaskRepository todoTaskRepository) {
        super();
        this.todoTaskRepository = todoTaskRepository;
    }

    private TodoTaskRepository todoTaskRepository;

//    public TodoControllerJpa() {
//    }

    @RequestMapping("todo-list")
    public String listAllTodoTasks(ModelMap model) {
        String username = getLoggedUsername(model);
        List<TodoTask> todoTasks= todoTaskRepository.findByUsername(username);

        model.addAttribute("todoTasks", todoTasks);
        return "todo-list";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.GET)
    public String goToNewTodoPage(ModelMap model) {
        String username = getLoggedUsername(model);
        TodoTask todoTask = new TodoTask(0,username,"",LocalDate.now(),false);
        model.put("todoTask",todoTask);
        return "add-todo";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
    public String addNewTodo(ModelMap model, @Valid TodoTask todoTask, BindingResult result) {
        if (result.hasErrors())
            return "add-todo";

        String username = getLoggedUsername(model);
        todoTask.setUsername(username);
        todoTaskRepository.save(todoTask);

        //todoService.addTodoTask(username,todoTask.getDescription(), todoTask.getTargetCompleteDate(),todoTask.isDone());
        return "redirect:todo-list";
    }

    @RequestMapping("delete-todo")
    public String deleteTodo(@RequestParam int id) {
        //todoService.deleteTodoById(id);
        todoTaskRepository.deleteById(id);
        return "redirect:todo-list";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.GET)
    public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
        //TodoTask todoTask = todoService.updateById(id);
        TodoTask todoTask = todoTaskRepository.findById(id).get();
        model.addAttribute("todoTask", todoTask);
        return "add-todo";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.POST)
    public String UpdateTodo(ModelMap model, @Valid TodoTask todoTask, BindingResult result) {
        if (result.hasErrors())
            return "add-todo";

        String username = getLoggedUsername(model);
        todoTask.setUsername(username);
        todoTaskRepository.save(todoTask);
        //todoService.updateTodo(todoTask);
        return "redirect:todo-list";
    }

    private String getLoggedUsername(ModelMap model) {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
//aaa