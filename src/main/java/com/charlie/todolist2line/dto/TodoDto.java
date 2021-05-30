package com.charlie.todolist2line.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodoDto{
    private String userId;
    private int todoId;
    private String todoTitle;
    private String todoContent;
    private boolean isDone;
    private Timestamp limitDateTime;
}