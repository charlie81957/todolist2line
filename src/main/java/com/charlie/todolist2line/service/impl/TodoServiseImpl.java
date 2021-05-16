package com.charlie.todolist2line.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.charlie.todolist2line.dto.TodoDto;
import com.charlie.todolist2line.mapper.TodoMapper;
import com.charlie.todolist2line.model.Todo;
import com.charlie.todolist2line.service.TodoService;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class TodoServiseImpl implements TodoService{

    private TodoMapper todoMapper;

    @Override
    public List<TodoDto> findTodoListByUserId(String userId) {
        List<Todo> todoList = new ArrayList<>();

        todoList = todoMapper.findTodoListByUserId(userId);

        List<TodoDto> todoDtoList = new ArrayList<>();
        
        for(Todo todo : todoList){
            TodoDto todoDto = new TodoDto();
            BeanUtils.copyProperties(todo, todoDto);
            todoDtoList.add(todoDto);
        }

        return todoDtoList;
    }

    @Override
    public void saveTodo(String userId, TodoDto todoDto) {
        Todo todo = new Todo();

        BeanUtils.copyProperties(todoDto, todo);

        todoMapper.insertTodo(userId, todo);        
    }

    @Override
    public void deleteTodo(String userId, int todoId) {
        todoMapper.deleteTodo(userId, todoId);
    }

    @Override
    public void deleteTodos(String userId, int[] todoIds) {
        for(int todoId : todoIds){
            todoMapper.deleteTodo(userId, todoId); 
        }
    }
    
}
