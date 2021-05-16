package com.charlie.todolist2line.mapper;

import java.util.List;

import com.charlie.todolist2line.model.Todo;

public interface TodoMapper {
    List<Todo> findTodoListByUserId(String userId);

    void insertTodo(String usreId, Todo todo);

    void deleteTodo(String userId, int todoId);

    void deleteTodoByUserId(String userId);
}
