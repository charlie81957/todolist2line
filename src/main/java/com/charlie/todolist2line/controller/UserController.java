package com.charlie.todolist2line.controller;

import com.charlie.todolist2line.dto.UserInfoDto;
import com.charlie.todolist2line.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
// @RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/loginInit")
    public String loginInit() {
        return "login";
    }

    /**
     * ユーザ作成
     * 
     * @param userId
     * @param userPassword
     */
    @ResponseBody
    @RequestMapping(value = "/signUp")
    public String signUp(@RequestBody UserInfoDto userInfoDto) {
        return userService.createUser(userInfoDto);
    }

    /**
     * 
     * @param userInfoDto
     */
    @ResponseBody
    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    public boolean SignIn(@RequestBody UserInfoDto userInfoDto) {
        return userService.isAbleToLogin(userInfoDto);
    }

    @RequestMapping(value = "/logout")
    public String logout() {
        return this.loginInit();
    }

    // 井村が作ったやつです。UserIdの存在確認用
    @ResponseBody
    @RequestMapping(value = "/isExist", method = RequestMethod.POST)
    @CrossOrigin
    public boolean isExistUserId(@RequestParam String userId) {
        return userService.isExistUserId(userId);
    }
}
