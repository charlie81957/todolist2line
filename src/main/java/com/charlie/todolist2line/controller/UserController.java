package com.charlie.todolist2line.controller;

import com.charlie.todolist2line.dto.UserInfoDto;
import com.charlie.todolist2line.service.UserService;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;

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
    @CrossOrigin
    public String signUp(@RequestBody UserInfoDto userInfoDto) {
        System.out.println(userInfoDto);
        String test = userService.createUser(userInfoDto);
        System.out.println(test);
        return test;
    }

    /**
     * 
     * @param userInfoDto
     */
    @ResponseBody
    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    @CrossOrigin
    public boolean SignIn(@RequestBody UserInfoDto userInfoDto) {
        System.out.println(userInfoDto);
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
    public boolean isExistUserId(@RequestBody String userId) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(userId);
            String test = rootNode.get("userId").toString();
            System.out.println(test.substring(1, test.length()-1));
            return userService.isExistUserId(test.substring(1, test.length()-1));
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        
        // return true;
    }
}
