package com.enp.todopro.api.dto;

import java.util.ArrayList;
import java.util.List;

import com.enp.todopro.api.model.Todo;

public class CategoryDto {
	
	private Long id;
    private String name;
    private List<Todo> todos = new ArrayList<>();
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Todo> getTodos() {
		return todos;
	}

	public void setTodos(List<Todo> todos) {
		this.todos = todos;
	}

	@Override
	public String toString() {
		return "CategoryDto [id=" + id + ", name=" + name + ", todos=" + todos + "]";
	}

}
