package com.charlie.todolist2line.model;


import java.security.Timestamp;

import lombok.Data;

@Data
class TodoDto{
    private String usreId;
    private String todoId;
    private String todoTitle;
    private String todoContent;
    private boolean isDone;
    Timestamp limitDateTime;
}