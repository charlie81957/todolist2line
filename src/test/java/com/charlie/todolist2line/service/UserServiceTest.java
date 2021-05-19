package com.charlie.todolist2line.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.charlie.todolist2line.dto.UserInfoDto;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    void ユーザーを新規登録できる() {

        // テストに用いるユーザーデータの作成
        UserInfoDto user = new UserInfoDto();
        user.setUserId("testuser2");
        user.setUserPassword("foobar");

        String actual = userService.createUser(user);

        assertEquals("success", actual);
    }

}
