package com.enp.todopro.api.dto;

/*
 * @(#)CategoryDto.java 1.0 12/11/2024
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

public class CategoryDto {
	
	private Long id;
    private String name;
    private List<Todo> todos = new ArrayList<>();
    
	public CategoryDto(Long id2, String name2) {
		// TODO Auto-generated constructor stub
	}

	public CategoryDto() {
		// TODO Auto-generated constructor stub
	}

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
