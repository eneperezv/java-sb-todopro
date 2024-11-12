package com.enp.todopro.api.dto;

import com.enp.todopro.api.model.TodoList;

public class TodoDto {
	
	private Long id;
    private String description;
    private Boolean completed = false;
    private TodoList todoList;
    
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
