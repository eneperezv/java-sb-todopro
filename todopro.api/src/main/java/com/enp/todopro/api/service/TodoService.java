package com.enp.todopro.api.service;

/*
 * @(#)TodoService.java 1.0 12/11/2024
 * 
 * El código implementado en este formulario esta protegido
 * bajo las leyes internacionales del Derecho de Autor, sin embargo
 * se entrega bajo las condiciones de la General Public License (GNU GPLv3)
 * descrita en https://www.gnu.org/licenses/gpl-3.0.html
 */

/**
 * @author eliezer.navarro
 * @version 1.0
 * @since 1.0
 */

import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enp.todopro.api.dto.TodoDto;
import com.enp.todopro.api.model.Todo;
import com.enp.todopro.api.repository.TodoRepository;

@Service
public class TodoService {
	
	@Autowired
	private TodoRepository todoRepository;
	
	public Todo buildEntity(TodoDto todoDto) {
		Todo todo = new Todo();
		todo.setId(todoDto.getId());
		todo.setDescription(todoDto.getDescription());
		todo.setCompleted(todoDto.getCompleted());
		//todo.setTodoList(todoDto.getTodoList());
		
		return todo;
	}
	
	public TodoDto buildDto(Optional<Todo> optional) {
		TodoDto todoDto = new TodoDto();
		todoDto.setId(optional.get().getId());
		todoDto.setDescription(optional.get().getDescription());
		todoDto.setCompleted(optional.get().getCompleted());
		//todoDto.setTodoList(optional.get().getTodoList());
		
		return todoDto;
	}
	
	public TodoDto buildDtoFromTodo(Todo todo) {
		TodoDto todoDto = new TodoDto();
		todoDto.setId(todo.getId());
		todoDto.setDescription(todo.getDescription());
		todoDto.setCompleted(todo.getCompleted());
		//todoDto.setTodoList(todo.getTodoList());
		
		return todoDto;
	}

    public TodoDto createTodo(TodoDto todoDto) {
        Todo todo = new Todo();
        todo.setDescription(todoDto.getDescription());
        todo.setCompleted(todoDto.getCompleted());
        // Map category and todoList if provided in TodoDto
        Todo savedTodo = todoRepository.save(todo);
        return new TodoDto(savedTodo.getId(), savedTodo.getDescription(), savedTodo.getCompleted());
    }

    public List<TodoDto> getAllTodos() {
        List<Todo> todos = todoRepository.findAll();
        return todos.stream()
                .map(t -> new TodoDto(t.getId(), t.getDescription(), t.getCompleted()))
                .collect(Collectors.toList());
    }

}
