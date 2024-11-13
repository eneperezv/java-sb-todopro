package com.enp.todopro.api.service;

/*
 * @(#)TodoListService.java 1.0 12/11/2024
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

import com.enp.todopro.api.dto.TodoListDto;
import com.enp.todopro.api.model.TodoList;
import com.enp.todopro.api.repository.TodoListRepository;

@Service
public class TodoListService {
	
	@Autowired
	private TodoListRepository todoListRepository;
	
	public TodoList buildEntity(TodoListDto todoListDto) {
		TodoList todoList = new TodoList();
		todoList.setId(todoListDto.getId());
		todoList.setTitle(todoListDto.getTitle());
		todoList.setUser(todoListDto.getUser());
		todoList.setTodos(todoListDto.getTodos());
		
		return todoList;
	}
	
	public TodoListDto buildDto(Optional<TodoList> optional) {
		TodoListDto todoListDto = new TodoListDto();
		todoListDto.setId(optional.get().getId());
		todoListDto.setTitle(optional.get().getTitle());
		todoListDto.setUser(optional.get().getUser());
		todoListDto.setTodos(optional.get().getTodos());
		
		return todoListDto;
	}
	
	public TodoListDto buildDtoFromCategory(TodoList todoList) {
		TodoListDto todoListDto = new TodoListDto();
		todoListDto.setId(todoList.getId());
		todoListDto.setTitle(todoList.getTitle());
		todoListDto.setUser(todoList.getUser());
		todoListDto.setTodos(todoList.getTodos());
		
		return todoListDto;
	}

}
