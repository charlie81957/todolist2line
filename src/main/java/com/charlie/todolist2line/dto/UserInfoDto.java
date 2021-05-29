package com.charlie.todolist2line.dto;

import lombok.Data;

@Data
public class UserInfoDto{
    private String userId;
    private String userPassword;

    public void setUserId(String uid) {
        this.userId = uid;
    }

    public void setUserPassword(String pw) {
        this.userPassword = pw;
    }
}