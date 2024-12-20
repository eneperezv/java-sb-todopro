package com.enp.todopro.api.controller;

/*
 * @(#)TodoController.java 1.0 23/11/2024
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

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enp.todopro.api.dto.TodoDto;
import com.enp.todopro.api.model.ErrorDetails;
import com.enp.todopro.api.model.ResponseDetails;
import com.enp.todopro.api.service.TodoService;

@RestController
@RequestMapping("/api/v1/todopro/todo")
public class TodoController {
	
	@Autowired
    private TodoService todoService;

    @PostMapping
    public ResponseDetails<?> createTodo(@RequestBody TodoDto todoDto) {
        try {
            TodoDto savedTodo = todoService.createTodo(todoDto);
            return new ResponseDetails<>("OK", new Date(), new ResponseEntity<>(savedTodo, HttpStatus.CREATED));
        } catch (Exception e) {
            ErrorDetails err = new ErrorDetails(new Date(), HttpStatus.INTERNAL_SERVER_ERROR.toString(), e.getMessage());
            return new ResponseDetails<>("ERROR", new Date(), new ResponseEntity<>(err, HttpStatus.INTERNAL_SERVER_ERROR));
        }
    }

    @GetMapping
    public ResponseDetails<?> getAllTodos() {
        try {
            List<TodoDto> todos = todoService.getAllTodos();
            return new ResponseDetails<>("OK", new Date(), new ResponseEntity<>(todos, HttpStatus.OK));
        } catch (Exception e) {
            ErrorDetails err = new ErrorDetails(new Date(), HttpStatus.INTERNAL_SERVER_ERROR.toString(), e.getMessage());
            return new ResponseDetails<>("ERROR", new Date(), new ResponseEntity<>(err, HttpStatus.INTERNAL_SERVER_ERROR));
        }
    }

}
