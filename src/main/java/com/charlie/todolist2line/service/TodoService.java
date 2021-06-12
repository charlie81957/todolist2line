package com.charlie.todolist2line.service;

import java.util.List;

import com.charlie.todolist2line.dto.TodoDto;

public interface TodoService {
    List<TodoDto> findAll();

    List<TodoDto>  findTodoListByUserId(String userId);

    TodoDto findTodoDtoById(int todoId);

    void saveTodo(TodoDto todoDto);

    void deleteTodo(int todoId);

    void deleteByUserId(String userId);

}
