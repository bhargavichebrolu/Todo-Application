package com.in28minutes.springboot.myfirstwebapp.todo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;
@Service
@SessionAttributes("name")
public class TodoService {
	private static List<Todo> todos = new ArrayList<>();
	public static int todoscount=0;
	static {
		Calendar calendar = Calendar.getInstance();

		// 1st element: one year from now
		calendar.add(Calendar.YEAR, 1);
		Date targetDate1 = calendar.getTime();
		todos.add(new Todo(++todoscount, "in28minutes", "Learn AWS", targetDate1, false));

		// 2nd element: two years from now
		calendar.add(Calendar.YEAR, 1);
		Date targetDate2 = calendar.getTime();
		todos.add(new Todo(++todoscount, "in28minutes", "Learn DevOps", targetDate2, false));

		// 3rd element: three years from now
		calendar.add(Calendar.YEAR, 1);
		Date targetDate3 = calendar.getTime();
		todos.add(new Todo(++todoscount, "in28minutes", "Learn Java", targetDate3, false));
	}
	public List<Todo> findByUserName(String Username){
		Predicate<? super Todo> predicate =todo -> todo.getUsername().equalsIgnoreCase(Username);
		return todos.stream().filter(predicate).toList();
	}
	public void addTodo(String username, String description, Date targetDate, Boolean done) {
	    Todo todo = new Todo(++todoscount, username, description, targetDate, done);
	    todos.add(todo);
	}
	public void deleteTodo(int id) {
		Predicate<? super Todo> predicate =todo -> todo.getId()==id;
		todos.removeIf(predicate);
	}
	public Todo findById(int id) {
		// TODO Auto-generated method stub\
		Predicate<? super Todo> predicate =todo -> todo.getId()==id;
		Todo todo=todos.stream().filter(predicate).findFirst().get();
		return todo;
	}
	public void updateTodo(@Valid Todo todo) {
		// TODO Auto-generated method stub
		deleteTodo(todo.getId());
		todos.add(todo);
		
	}
}
