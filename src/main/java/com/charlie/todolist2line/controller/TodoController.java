package com.charlie.todolist2line.controller;

import java.util.ArrayList;
import java.util.List;

import com.charlie.todolist2line.dto.TodoDto;
import com.charlie.todolist2line.service.TodoService;
import com.charlie.todolist2line.model.UserInfo;
import com.charlie.todolist2line.repo.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TodoController {

    private TodoService todoService;

    @ResponseBody
    @RequestMapping("/init")
    public String Init(){
        return "todo/init";
    }
    
    @RequestMapping("/todo/{userId}")
    public List<TodoDto> todoInit(@PathVariable("userId")String userId){

        List<TodoDto> todoDtoList = todoService.findTodoListByUserId(userId);

        return todoDtoList;
    }

    @RequestMapping("/todo/save")
    public void save(@RequestParam String userId, @RequestParam TodoDto todoDto){
        todoService.saveTodo(userId, todoDto);
    }

    @RequestMapping("/todo/delete")
    public void delete(@RequestParam String userId, @RequestParam int todoId){
        todoService.deleteTodo(userId, todoId);
    }

    @RequestMapping("/todos/delete")
    public void deletes(@RequestParam String userId, @RequestParam int[] todoIds){
        todoService.deleteTodos(userId, todoIds);
    }

    @Autowired
    UserRepository repo;

    @RequestMapping("/test/search")
    @ResponseBody
    public List<UserInfo> FindTest(@RequestParam("userId") String id) {
        if (id.equals("")) {
            return repo.findAll();
        } else {
            List<UserInfo> res = new ArrayList<UserInfo>();
            if (repo.findById(id).isPresent()) {
                res.add(repo.findById(id).get());
            }
            return res;
        }
    }

    @RequestMapping("/test/update")
    @ResponseBody
    public String UpdateTest(@RequestBody UserInfo user) {
        try {
            repo.save(user);
            return user.getUserId() + "was updated.";
        } catch (Exception e) {
            return "System error happened.";
        }
    }

    @RequestMapping("/test/delete")
    @ResponseBody
    public String DeleteTest(@RequestParam("userId") String id) {
        try {
            repo.deleteById(id);
            return id + "was deleted.";
        } catch (Exception e) {
            return "System error happened.";
        }
    }
}
