package com.charlie.todolist2line.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class TodoDto{
    private String usreId;
    private String todoId;
    private String todoTitle;
    private String todoContent;
    private boolean isDone;
    Timestamp limitDateTime;
}