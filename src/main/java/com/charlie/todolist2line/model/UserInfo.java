package com.charlie.todolist2line.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "user_info")
public class UserInfo {

    @Id
    @Column(name = "user_id")
    private String userId;

    @Column(name = "password")
    private String password;

}
