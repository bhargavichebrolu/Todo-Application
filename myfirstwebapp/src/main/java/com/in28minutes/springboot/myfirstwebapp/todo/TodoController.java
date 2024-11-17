package com.in28minutes.springboot.myfirstwebapp.todo;

import java.util.Date;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

//@Controller
public class TodoController {
	private TodoService todoService;
	
public TodoController(TodoService todoService) {
		super();
		this.todoService = todoService;
	}

@RequestMapping(value="todos",method=RequestMethod.GET)
public String listAllTodos(ModelMap model) {
	String username = getLoggedInUserName(model);
	List<Todo> todos=todoService.findByUserName(username);
	model.addAttribute("todos", todos);
	return "listTodos";
}
@RequestMapping(value="add-todo", method=RequestMethod.GET)
public String showNewTodoPage(ModelMap model) {
    String username = getLoggedInUserName(model);
    Todo todo = new Todo(null, username, "", new Date(), false); 
    model.addAttribute("todo", todo);
    return "todo";
}


@RequestMapping(value="add-todo", method=RequestMethod.POST)
public String addNewTodoPage(ModelMap model,@Valid Todo todo,BindingResult result) {
	if(result.hasErrors()) {
		return "todo";
	}
    String username = getLoggedInUserName(model);
    todoService.addTodo(username, todo.getDescription(), todo.getTargetDate(), false);
    return "redirect:todos";
}
@RequestMapping(value="delete-todo",method=RequestMethod.GET)
public String deleteTodo(@RequestParam int id) {
	//delete Todo
	todoService.deleteTodo(id);
	return "redirect:todos";
}
@RequestMapping(value="update-todo",method=RequestMethod.GET)
public String updateTodo(@RequestParam int id,ModelMap model) {
	//update Todo
	Todo todo=todoService.findById(id);
	model.addAttribute("todo", todo);
	return "todo";
}
@RequestMapping(value="update-todo", method=RequestMethod.POST)
public String updateTodo(ModelMap model,@Valid Todo todo,BindingResult result) {
	if(result.hasErrors()) {
		return "todo";
	}
    String username = getLoggedInUserName(model);
    todoService.updateTodo(todo);
    return "redirect:todos";
}
private String getLoggedInUserName(ModelMap model) {
	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	return authentication.getName();
	}
}
