package com.charlie.todolist2line.repo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import com.charlie.todolist2line.model.UserInfo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest
public class UserRepositoryTest {
    
    @Autowired
    UserRepository userRepo;

    @BeforeEach
    void showStartMsg(TestInfo testInfo) {
        System.out.println(">-----" + testInfo.getTestMethod().get().getName() + " START-----<");
    }

    @AfterEach
    void showEndMsg(TestInfo testInfo) {
        System.out.println(">-----" + testInfo.getTestMethod().get().getName() + " END-----<");
    }

    @Test
    void ユーザーを全件検索できる(){
        List<UserInfo> result = userRepo.findAll();

        for (UserInfo item : result) {
            System.out.println("検索結果：\t" + item);
        }
    }

    @Test
    @Transactional
    void ユーザーを一件追加できる(){
        UserInfo testUser = new UserInfo("test","testPass");

        System.out.println("更新前データ:\t" + userRepo.findById(testUser.getUserId()));
        System.out.println("更新後データ:\t" + userRepo.save(testUser));

        //挿入したユーザーが存在しているか確認
        Optional<UserInfo> optionalUser = userRepo.findById(testUser.getUserId());
        boolean actual = optionalUser.isPresent();

        assertEquals(true, actual);

    }

    @Test
    @Transactional
    void ユーザーを一件削除できる(){
        UserInfo testUser = new UserInfo("test","testPass");

        userRepo.delete(testUser);

        //削除したユーザーが存在しているか確認
        Optional<UserInfo> optionalUser = userRepo.findById(testUser.getUserId());
        boolean actual = optionalUser.isPresent();

        assertEquals(false, actual);

    }
}
