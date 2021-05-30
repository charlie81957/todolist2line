package com.charlie.todolist2line.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.transaction.Transactional;

import com.charlie.todolist2line.dto.UserInfoDto;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    // テストに用いるユーザーデータの作成
    UserInfoDto testUser = new UserInfoDto("testUser","testPass");
  
    @BeforeEach
    void showStartMsg(TestInfo testInfo) {
        System.out.println(">-----" + testInfo.getTestMethod().get().getName() + " START-----<");
    }

    @AfterEach
    void showEndMsg(TestInfo testInfo) {
        System.out.println(">-----" + testInfo.getTestMethod().get().getName() + " END-----<");
    }


    @Test
    @Transactional
    void ユーザーを新規登録できる() {

        String actual = userService.createUser(testUser);

        System.out.println(userService.findUserById(testUser.getUserId()));

        assertEquals("success", actual);
    }


    @Test
    @Transactional
    void ログインに成功する(){

        //テストに用いるユーザーデータの作成
        UserInfoDto user = new UserInfoDto("test","testPass");

        userService.createUser(user);

        boolean actual = userService.isAbleToLogin(user); 

        assertEquals(true, actual);
    }

    @Test
    @Transactional
    void ログインに失敗する_userIdのみ違う場合(){

        //テスト用ユーザーを挿入
        userService.createUser(testUser);

        //テストに用いるユーザーデータの生成2
        UserInfoDto user2 = new UserInfoDto("testUser2","testPass");
        boolean actual = userService.isAbleToLogin(user2); 

        assertEquals(false, actual);
    }
    @Test
    @Transactional
    void ログインに失敗する_passworddのみ違う場合(){

        //テスト用ユーザーを挿入
        userService.createUser(testUser);

        //テストに用いるユーザーデータの生成2
        UserInfoDto user2 = new UserInfoDto("testU","testPass2");
        boolean actual = userService.isAbleToLogin(user2); 

        assertEquals(false, actual);
    }

    @Test
    @Transactional
    void ユーザーを一件検索できる(){
        //テストユーザーを挿入
        userService.createUser(testUser);

        //テスト用に用いるユーザーIDを生成
        String userId = "testUser";

        UserInfoDto user = userService.findUserById(userId);

        boolean actual = userId.equals(user.getUserId());

        assertEquals(true, actual);
    }

    @Test
    @Transactional
    void ユーザーを更新できる(){
        //テストユーザーを挿入
        userService.createUser(testUser);

        testUser.setUserPassword("testPass2");

        String actual = userService.updateUser(testUser);

        System.out.println(userService.findUserById("testUser"));

        assertEquals(testUser.getUserId() + "was updated.", actual);
    }

    @Test
    @Transactional
    void ユーザーを削除できる(){
        userService.createUser(testUser);

        String actual = userService.deleteUser(testUser.getUserId());

        assertEquals(testUser.getUserId() + "was deleted.", actual);
    }


}
