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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
public class TodoController {

    @Autowired
    private TodoService todoService;

    // @ResponseBody
    @RequestMapping("/init")
    @ResponseBody
    public String Init() {
        // return "todo/init";
        return "todo";
    }

    @RequestMapping("/todo/show")
    @ResponseBody
    @CrossOrigin
    public List<TodoDto> todoInit(@RequestParam String userId) {

        System.out.println(userId);
        List<TodoDto> todoDtoList = todoService.findTodoListByUserId(userId);

        return todoDtoList;
    }

    @RequestMapping("/todo/save")
    @ResponseBody
    @CrossOrigin
    public String save(@RequestBody TodoDto todoDto) {
        todoService.saveTodo(todoDto);
        return "success";
    }

    @RequestMapping("/todo/delete")
    @ResponseBody
    @CrossOrigin
    public void delete(@RequestParam int todoId) {
        todoService.deleteTodo(todoId);
    }

    @RequestMapping("/todos/delete")
    @ResponseBody
    public void deletes(@RequestParam String userId) {
        todoService.deleteByUserId(userId);
    }

}
