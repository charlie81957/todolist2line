package com.charlie.todolist2line.service;

import java.util.List;

import com.charlie.todolist2line.dto.TodoDto;

public interface TodoService {
    List<TodoDto>  findTodoListByUserId(String userId);

    void saveTodo(String userId, TodoDto todoDto);

    void deleteTodo(String userId, int todoId);

    void deleteTodos(String userId, int[] todoIds);//totoをまとめて削除する場合 一応作成
}
