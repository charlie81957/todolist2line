package com.charlie.todolist2line.model;

import java.security.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "todo_info")
public class Todo {

    @Id
    @Column(name = "user_id")
    private String userId;

    @Id
    @Column(name = "todo_id")
    private String todoId;

    @Column(name = "todo_title")
    private String todoTitle;

    @Column(name = "todo_content")
    private String todoContent;

    @Column(name = "limit_datetime")
    Timestamp limitDateTime;

    @Column(name = "is_done")
    private boolean isDone;

}