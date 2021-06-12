package com.charlie.todolist2line.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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