package com.charlie.todolist2line.service;


import java.sql.Timestamp;
import java.util.List;

import javax.transaction.Transactional;

import com.charlie.todolist2line.dto.TodoDto;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TodoServiceTest {
    
    @Autowired
    private TodoService todoService;

    
    TodoDto testTodoDto = new TodoDto();
    
    @BeforeEach
    void showStartMsg(TestInfo testInfo) {
        //テストに用いるTodoデータの作成
        testTodoDto.setUserId("testId");
        testTodoDto.setTodoTitle("testTitle");
        testTodoDto.setTodoContent("testContent");
        Timestamp limitDateTime = new Timestamp(System.currentTimeMillis());
        testTodoDto.setLimitDateTime(limitDateTime);
        testTodoDto.setDone(false);
        
        System.out.println(">-----" + testInfo.getTestMethod().get().getName() + " START-----<");
    }

    @AfterEach
    void showEndMsg(TestInfo testInfo) {
        System.out.println(">-----" + testInfo.getTestMethod().get().getName() + " END-----<");
    }

    @Test
    void TodoをTodoIdで検索できる(){
        //検索するtodoId
        int todoId = 1;

        TodoDto todoDto = todoService.findTodoDtoById(todoId);

        System.out.println("検索したよ " + todoDto);
    }

    @Test
    void TodoをuserIdで検索できる(){
        //検索するuserId
        String userId = "hoge";

        List<TodoDto> todoListDto = todoService.findTodoListByUserId(userId);
        todoListDto.stream().forEach(System.out::println);
    }

    @Test
    @Transactional
    void Todoを一件追加できる(){
        List<TodoDto> todoDtoList;

        todoDtoList = todoService.findAll();
        System.out.println("挿入前");
        todoDtoList.stream().forEach(System.out::println);

        //挿入
        todoService.saveTodo(testTodoDto);

        todoDtoList = todoService.findAll();
        System.out.println("挿入後");
        todoDtoList.stream().forEach(System.out::println);

    }

    @Test
    @Transactional
    void Todoを一件更新できる(){
        TodoDto todoDto;
        todoDto = todoService.findTodoDtoById(1);
        System.out.println("更新前" + " " + todoDto);

        //更新
        todoDto.setDone(true);
        todoService.saveTodo(todoDto);

        todoDto = todoService.findTodoDtoById(1);
        System.out.println("更新後" + " " + todoDto);
    }

    @Test
    @Transactional
    void TodoをTodoIdで一件削除できる(){
        List<TodoDto> todoDtoList;

        todoDtoList = todoService.findAll();
        System.out.println("挿入前");
        todoDtoList.stream().forEach(System.out::println);

        //挿入
        todoService.deleteTodo(1);

        todoDtoList = todoService.findAll();
        System.out.println("挿入後");
        todoDtoList.stream().forEach(System.out::println);
    }

    @Test
    @Transactional
    void TodoをuserIdで削除できる(){
        List<TodoDto> todoDtoList;
        String userId = "testId";

        todoDtoList = todoService.findAll();
        System.out.println("挿入前");
        todoDtoList.stream().forEach(System.out::println);

        //挿入
        todoService.deleteByUserId(userId);

        todoDtoList = todoService.findAll();
        System.out.println("挿入後");
        todoDtoList.stream().forEach(System.out::println);
    }
}
