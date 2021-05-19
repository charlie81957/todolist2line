package com.charlie.todolist2line.service;

import java.util.List;

import com.charlie.todolist2line.model.Todo;
import com.charlie.todolist2line.repo.TodoRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TodoServiceTest {

    // @Autowired
    // UserService userService;

    @Autowired
    TodoRepository todoRepo;

    @Test
    void Todoを全件取得できる() {
        List<Todo> result = todoRepo.findAll();
        for (Todo item : result) {
            System.out.print("\t" + item);
        }
    }

    @Test
    void Todoを一件追加できる() {

        Todo testcase = new Todo();
        testcase.setUserId("hoge");
        testcase.setTodoTitle("買い物");
        testcase.setDone(false);

        System.out.println(testcase);

        todoRepo.save(testcase);
    }
}
