package com.enp.todopro.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enp.todopro.api.dto.CategoryDto;
import com.enp.todopro.api.model.Category;
import com.enp.todopro.api.repository.TodoListRepository;

@Service
public class TodoListService {
	
	@Autowired
	private TodoListRepository todoListRepository;
	
	public Category buildEntity(CategoryDto categoryDto) {
		Category category = new Category();
		category.setId(categoryDto.getId());
		category.setName(categoryDto.getName());
		category.setTodos(categoryDto.getTodos());
		
		return category;
	}
	
	public CategoryDto buildDto(Optional<Category> optional) {
		CategoryDto categoryDto = new CategoryDto();
		categoryDto.setId(optional.get().getId());
		categoryDto.setName(optional.get().getName());
		categoryDto.setTodos(optional.get().getTodos());
		
		return categoryDto;
	}
	
	public CategoryDto buildDtoFromCategory(Category category) {
		CategoryDto categoryDto = new CategoryDto();
		categoryDto.setId(category.getId());
		categoryDto.setName(category.getName());
		categoryDto.setTodos(category.getTodos());
		
		return categoryDto;
	}

}
