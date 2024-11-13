package com.enp.todopro.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enp.todopro.api.model.TodoList;

public interface TodoListRepository extends JpaRepository<TodoList,Long> {

}
