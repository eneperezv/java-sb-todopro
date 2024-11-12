package com.enp.todopro.api.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.enp.todopro.api.dto.TodoDto;
import com.enp.todopro.api.model.Todo;

@Service
public class TodoService {
	
	public Todo buildEntity(TodoDto todoDto) {
		Todo todo = new Todo();
		todo.setId(todoDto.getId());
		todo.setDescription(todoDto.getDescription());
		todo.setCompleted(todoDto.getCompleted());
		todo.setTodoList(todoDto.getTodoList());
		
		return todo;
	}
	
	public TodoDto buildDto(Optional<Todo> optional) {
		TodoDto todoDto = new TodoDto();
		todoDto.setId(optional.get().getId());
		todoDto.setDescription(optional.get().getDescription());
		todoDto.setCompleted(optional.get().getCompleted());
		todoDto.setTodoList(optional.get().getTodoList());
		
		return todoDto;
	}
	
	public TodoDto buildDtoFromTodo(Todo todo) {
		TodoDto todoDto = new TodoDto();
		todoDto.setId(todo.getId());
		todoDto.setDescription(todo.getDescription());
		todoDto.setCompleted(todo.getCompleted());
		todoDto.setTodoList(todo.getTodoList());
		
		return todoDto;
	}

}
