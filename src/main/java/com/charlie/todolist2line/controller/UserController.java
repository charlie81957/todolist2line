package com.charlie.todolist2line.controller;

import com.charlie.todolist2line.dto.UserInfoDto;
import com.charlie.todolist2line.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

// @CrossOrigin // Edited by imura 2021-0523--https://spring.io/blog/2015/06/08/cors-support-in-spring-framework
@Controller
// @RestController
public class UserController {
    
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/loginInit")
    public String loginInit(){
        return "login";
    }

    /**
     * ユーザ作成
     * @param userId
     * @param userPassword
     */
    @ResponseBody
    @RequestMapping(value = "/signUp")
    public String signUp(@RequestParam UserInfoDto userInfoDto){
        return userService.createUser(userInfoDto);
    }

    /**
     * 
     * @param userInfoDto
     */
    @ResponseBody           
    @RequestMapping(value="/signIn", method=RequestMethod.POST)
    @CrossOrigin
    public boolean SignIn(@RequestBody UserInfoDto userInfoDto) {
        // return userService.isAbelToLogin(userInfoDto);
        return true; // EDIT!!!
    }
    
    @RequestMapping(value = "/loguot")
    public String logout(){
        return this.loginInit();
    }

    // 井村が作ったやつです。UserIdの存在確認用
    @ResponseBody           
    @RequestMapping(value="/isExist", method=RequestMethod.POST)
    @CrossOrigin
    public boolean isExistUserId(@RequestBody String uid) {
        // return userService.isAbelToLogin(userInfoDto);
        return true; // EDIT!!!
    }
}
