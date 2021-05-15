package com.charlie.todolist2line.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
