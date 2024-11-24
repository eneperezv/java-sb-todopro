package com.enp.todopro.api.controller;

/*
 * @(#)TodoListController.java 1.0 23/11/2024
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

import com.enp.todopro.api.dto.TodoListDto;
import com.enp.todopro.api.model.ErrorDetails;
import com.enp.todopro.api.model.ResponseDetails;
import com.enp.todopro.api.service.TodoListService;

@RestController
@RequestMapping("/api/v1/todopro/todolist")
public class TodoListController {
	
	@Autowired
    private TodoListService todoListService;

    @PostMapping
    public ResponseDetails<?> createTodoList(@RequestBody TodoListDto todoListDto) {
        try {
            TodoListDto savedTodoList = todoListService.createTodoList(todoListDto);
            return new ResponseDetails<>("OK", new Date(), new ResponseEntity<>(savedTodoList, HttpStatus.CREATED));
        } catch (Exception e) {
            ErrorDetails err = new ErrorDetails(new Date(), HttpStatus.INTERNAL_SERVER_ERROR.toString(), e.getMessage());
            return new ResponseDetails<>("ERROR", new Date(), new ResponseEntity<>(err, HttpStatus.INTERNAL_SERVER_ERROR));
        }
    }

    @GetMapping
    public ResponseDetails<?> getAllTodoLists() {
        try {
            List<TodoListDto> todoLists = todoListService.getAllTodoLists();
            return new ResponseDetails<>("OK", new Date(), new ResponseEntity<>(todoLists, HttpStatus.OK));
        } catch (Exception e) {
            ErrorDetails err = new ErrorDetails(new Date(), HttpStatus.INTERNAL_SERVER_ERROR.toString(), e.getMessage());
            return new ResponseDetails<>("ERROR", new Date(), new ResponseEntity<>(err, HttpStatus.INTERNAL_SERVER_ERROR));
        }
    }

}
