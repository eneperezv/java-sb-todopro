package com.enp.todopro.api.dto;

/*
 * @(#)TodoListDto.java 1.0 12/11/2024
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

import java.util.ArrayList;
import java.util.List;

import com.enp.todopro.api.model.Todo;
import com.enp.todopro.api.model.User;

public class TodoListDto {
	
	private Long id;
    private String title;
    private User user;
    private List<Todo> todos = new ArrayList<>();
    
	public TodoListDto(Long id2, String title2) {
		// TODO Auto-generated constructor stub
	}

	public TodoListDto() {
		// TODO Auto-generated constructor stub
	}

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
