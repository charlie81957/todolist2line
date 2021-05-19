package com.charlie.todolist2line.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class TodoPK implements Serializable {

    @Column(name = "user_index")
    private int userId;

    @Column(name = "todo_id")
    private int todoId;

}
