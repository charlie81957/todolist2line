package com.charlie.todolist2line.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.charlie.todolist2line.dto.TodoDto;
import com.charlie.todolist2line.model.Todo;
import com.charlie.todolist2line.repo.TodoRepository;
import com.charlie.todolist2line.service.TodoService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TodoServiseImpl implements TodoService{

    @Autowired
    private TodoRepository todoRepository;

    public List<TodoDto> findAll(){
        List <Todo> todoList = todoRepository.findAll();

        List<TodoDto> todoDtoList = new ArrayList<>();

        for(Todo todo : todoList){
            TodoDto todoDto = new TodoDto();
            BeanUtils.copyProperties(todo, todoDto);
            todoDtoList.add(todoDto);
        }

        return todoDtoList;
    }

    @Override
    public List<TodoDto> findTodoListByUserId(String userId) {
        List<Todo> todoList = todoRepository.findByUserId(userId);

        List<TodoDto> todoDtoList = new ArrayList<>();
        
        for(Todo todo : todoList){
            TodoDto todoDto = new TodoDto();
            BeanUtils.copyProperties(todo, todoDto);
            todoDtoList.add(todoDto);
        }

        return todoDtoList;
    }

    @Override
    public TodoDto findTodoDtoById(int todoId) {
        Optional<Todo> todo = todoRepository.findById(todoId);

        if(todo.isPresent()){
            TodoDto todoDto = new TodoDto();
            BeanUtils.copyProperties(todo.get(), todoDto);
            return todoDto;
        }else{
            return null;
        }
    }

    @Override
    public void saveTodo(TodoDto todoDto) {
        Todo todo = new Todo();

        BeanUtils.copyProperties(todoDto, todo);

        todoRepository.save(todo);        
    }

    @Override
    public void deleteTodo(int todoId) {
        todoRepository.deleteById(todoId);
    }

    @Override
    public void deleteByUserId(String userId) {
        todoRepository.deleteByUserId(userId);
    }
    
}
