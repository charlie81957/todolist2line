package com.charlie.todolist2line.repo;

import java.util.List;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import com.charlie.todolist2line.model.Todo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TodoRepositoryTest {

    @Autowired
    TodoRepository todoRepo;

    @BeforeEach
    void showStartMsg(TestInfo testInfo) {
        System.out.println(">-----" + testInfo.getTestMethod().get().getName() + " START-----<");
    }

    @AfterEach
    void showEndMsg(TestInfo testInfo) {
        System.out.println(">-----" + testInfo.getTestMethod().get().getName() + " END-----<");
    }

    @Test
    void Todoを全件取得できる() {

        List<Todo> result = todoRepo.findAll();
        for (Todo item : result) {
            System.out.println("検索結果：\t" + item);
        }

    }

    @Test
    void TodoをTodoIdで検索できる() {

        int query = 1;
        Todo result = todoRepo.findById(query).get();

        System.out.println("検索クエリ：\t" + "todo_id = " + query);
        System.out.println("検索結果：\t" + result);

    }

    @Test
    void TodoをUserIdで検索できる() {

        String query = "hoge";
        List<Todo> result = todoRepo.findByUserId(query);

        System.out.println("検索クエリ：\t" + "user_id = " + query);
        for (Todo item : result) {
            System.out.println("取得データ：\t" + item);
        }

    }

    @Test
    @Transactional
    void Todoを一件追加できる() {

        Todo testcase = new Todo();
        testcase.setUserId("hoge");
        testcase.setTodoTitle("買い物");
        testcase.setDone(false);

        System.out.println("追加するデータ：\t" + testcase);
        System.out.println("追加されたデータ：\t" + todoRepo.save(testcase));

    }

    @Test
    @Transactional
    void Todoを一件更新できる() {

        Todo testcase = new Todo();
        testcase.setTodoId(2);
        testcase.setUserId("hoge");
        testcase.setTodoTitle("美容院");
        testcase.setDone(true);

        System.out.println("更新前データ：\t" + todoRepo.findById(testcase.getTodoId()).get());
        System.out.println("更新後データ：\t" + todoRepo.save(testcase));

    }

    @Test
    @Transactional
    void Todoを一件削除できる() {

        int query = 1;

        System.out.println("削除前データ：\t" + todoRepo.findById(query).get());
        todoRepo.deleteById(query);
        try {
            todoRepo.findById(query).get();
        } catch (NoSuchElementException e) {
            System.out.println("削除後データ：\t" + e.getClass().getName());
        }

    }

    @Test
    @Transactional
    void 指定のユーザーのTodoを削除できる() {

        String query = "hoge";

        System.out.println("削除前データ：\t" + todoRepo.findByUserId(query).size() + "件");
        todoRepo.deleteByUserId(query);
        System.out.println("削除後データ：\t" + todoRepo.findByUserId(query).size() + "件");

    }

}