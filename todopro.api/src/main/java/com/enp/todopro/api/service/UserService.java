package com.enp.todopro.api.service;

/*
 * @(#)UserService.java 1.0 31/10/2024
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

import com.enp.todopro.api.dto.UserDto;
import com.enp.todopro.api.model.User;
import com.enp.todopro.api.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public UserDto createUser(UserDto userDto) {
		return buildDto(Optional.of(userRepository.save(buildEntity(userDto))));
	}

	public UserDto findById(Long id) {
		return buildDto(userRepository.findById(id));
	}
	
	public UserDto updateUser(UserDto userDto) {
		return buildDto(Optional.of(userRepository.save(buildEntity(userDto))));
	}
	
	public User buildEntity(UserDto userDto) {
		User user = new User();
		user.setId(userDto.getId());
		user.setUsername(userDto.getUsername());
		user.setPassword(userDto.getPassword());
		user.setRole(userDto.getRole());
		user.setName(userDto.getName());
		
		return user;
	}
	
	public UserDto buildDto(Optional<User> optional) {
		UserDto userDto = new UserDto();
		userDto.setId(optional.get().getId());
		userDto.setUsername(optional.get().getUsername());
		userDto.setPassword(optional.get().getPassword());
		userDto.setRole(optional.get().getRole());
		userDto.setName(optional.get().getName());
		
		return userDto;
	}

}
