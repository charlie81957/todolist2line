package com.charlie.todolist2line.controller;

import java.util.List;

import com.charlie.todolist2line.dto.TodoDto;
import com.charlie.todolist2line.service.TodoService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TodoController {

    private TodoService todoService;

    // @ResponseBody
    @RequestMapping("/init")
    public String Init() {
        // return "todo/init";
        return "todo";
    }

    @RequestMapping("/todo/{userId}")
    public List<TodoDto> todoInit(@PathVariable("userId") String userId) {

        List<TodoDto> todoDtoList = todoService.findTodoListByUserId(userId);

        return todoDtoList;
    }

    @RequestMapping("/todo/save")
    public void save(@RequestParam String userId, @RequestParam TodoDto todoDto) {
        todoService.saveTodo(userId, todoDto);
    }

    @RequestMapping("/todo/delete")
    public void delete(@RequestParam String userId, @RequestParam int todoId) {
        todoService.deleteTodo(userId, todoId);
    }

    @RequestMapping("/todos/delete")
    public void deletes(@RequestParam String userId, @RequestParam int[] todoIds) {
        todoService.deleteTodos(userId, todoIds);
    }

}
