package com.charlie.todolist2line.controller;

import java.util.List;

import com.charlie.todolist2line.dto.TodoDto;
import com.charlie.todolist2line.service.TodoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TodoController {

    @Autowired
    private TodoService todoService;

    // @ResponseBody
    @RequestMapping("/init")
    public String Init() {
        // return "todo/init";
        return "todo";
    }

    @RequestMapping("/todo/show")
    public List<TodoDto> todoInit(String userId) {

        List<TodoDto> todoDtoList = todoService.findTodoListByUserId(userId);

        return todoDtoList;
    }

    @RequestMapping("/todo/save")
    public void save(@RequestBody TodoDto todoDto) {
        todoService.saveTodo(todoDto);
    }

    @RequestMapping("/todo/delete")
    public void delete(@RequestParam int todoId) {
        todoService.deleteTodo(todoId);
    }

    @RequestMapping("/todos/delete")
    public void deletes(@RequestParam String userId) {
        todoService.deleteByUserId(userId);
    }

}
