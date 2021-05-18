package com.charlie.todolist2line.repo;

import com.charlie.todolist2line.model.Todo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, String> {

}
