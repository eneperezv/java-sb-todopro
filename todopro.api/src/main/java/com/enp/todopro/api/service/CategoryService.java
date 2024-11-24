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

import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enp.todopro.api.dto.CategoryDto;
import com.enp.todopro.api.model.Category;
import com.enp.todopro.api.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
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

    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = new Category();
        category.setName(categoryDto.getName());
        Category savedCategory = categoryRepository.save(category);
        return new CategoryDto(savedCategory.getId(), savedCategory.getName());
    }

    public List<CategoryDto> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream()
                .map(c -> new CategoryDto(c.getId(), c.getName()))
                .collect(Collectors.toList());
    }

}
