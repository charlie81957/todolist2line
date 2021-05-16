package com.charlie.todolist2line.controller;

import java.util.List;

import com.charlie.todolist2line.model.UserInfo;
import com.charlie.todolist2line.repo.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class TodoController {

    @RequestMapping("/init")
    public String Init() {
        return "init";
    }

    @RequestMapping("/")
    public String Login() {
        return "login";
    }

    @RequestMapping("/edit")
    public String UserEdit() {
        return "userEdit";
    }

    @Autowired
    UserRepository repo;

    @RequestMapping("/searchAll")
    @ResponseBody
    public List<UserInfo> findAll() {
        return repo.findAll();
    }
}
