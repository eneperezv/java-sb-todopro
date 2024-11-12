package com.enp.todopro.api.service;

/*
 * @(#)CategoryService.java 1.0 12/11/2024
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

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enp.todopro.api.dto.TodoDto;
import com.enp.todopro.api.model.Todo;
import com.enp.todopro.api.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
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
