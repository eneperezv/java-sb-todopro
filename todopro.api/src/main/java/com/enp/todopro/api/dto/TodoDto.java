package com.enp.todopro.api.dto;

/*
 * @(#)TodoDto.java 1.0 12/11/2024
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

import com.enp.todopro.api.model.TodoList;

public class TodoDto {
	
	private Long id;
    private String description;
    private Boolean completed = false;
    private TodoList todoList;
    
	public TodoDto(Long id2, String description2, Boolean completed2) {
		// TODO Auto-generated constructor stub
	}

	public TodoDto() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getCompleted() {
		return completed;
	}

	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}

	public TodoList getTodoList() {
		return todoList;
	}

	public void setTodoList(TodoList todoList) {
		this.todoList = todoList;
	}

	@Override
	public String toString() {
		return "TodoDto [id=" + id + ", description=" + description + ", completed=" + completed + ", todoList="
				+ todoList + "]";
	}

}
