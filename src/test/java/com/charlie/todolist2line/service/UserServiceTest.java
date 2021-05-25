package com.charlie.todolist2line.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.transaction.Transactional;

import com.charlie.todolist2line.dto.UserInfoDto;
import com.charlie.todolist2line.model.UserInfo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    @Transactional
    void ユーザーを新規登録できる() {

        // テストに用いるユーザーデータの作成
        UserInfoDto user = new UserInfoDto();
        user.setUserId("testuser3");
        user.setUserPassword("foobar");

        String actual = userService.createUser(user);

        assertEquals("success", actual);
    }

    @Test
    void ログインに成功する(){

        //テストに用いるユーザーデータの作成
        UserInfoDto user = new UserInfoDto();
        user.setUserId("testUser");
        user.setUserPassword("testPass");

        boolean actual = userService.isAbleToLogin(user); 

        assertEquals(true, actual);
    }

    @Test
    void ログインに失敗する(){

        //テストに用いるユーザーデータの作成
        UserInfoDto user = new UserInfoDto();
        user.setUserId("testUser");
        user.setUserPassword("testPassHoge");

        boolean actual = userService.isAbleToLogin(user); 

        assertEquals(false, actual);
    }

    @Test
    void ユーザーを一件検索できる(){
        //テスト用に用いるユーザーIDを生成
        String userId = "testUser";

        UserInfoDto user = userService.findUserById(userId);

        boolean actual = userId.equals(user.getUserId());

        assertEquals(true, actual);
    }

    @Test
    @Transactional
    void ユーザーを更新できる(){
        // テストに用いるユーザーデータの作成
        UserInfoDto user = new UserInfoDto();
        user.setUserId("testUser");
        user.setUserPassword("userPass");

        String actual = userService.updateUser(user);

        assertEquals("success", actual);
    }

    @Test
    @Transactional
    void ユーザーを削除できる(){
        // テストに用いるユーザーデータの作成
        String userId = "testUser";

        String actual = userService.deleteUser(userId);

        assertEquals("success", actual);
    }


}
