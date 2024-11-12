package com.enp.todopro.api.dto;

import java.util.ArrayList;
import java.util.List;

import com.enp.todopro.api.model.Todo;
import com.enp.todopro.api.model.User;

public class TodoListDto {
	
	private Long id;
    private String title;
    private User user;
    private List<Todo> todos = new ArrayList<>();
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Todo> getTodos() {
		return todos;
	}

	public void setTodos(List<Todo> todos) {
		this.todos = todos;
	}

	@Override
	public String toString() {
		return "TodoListDto [id=" + id + ", title=" + title + ", user=" + user + ", todos=" + todos + "]";
	}

}
