package com.charlie.todolist2line.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo{
    private String userId;
    private String encryptionPassword;
}