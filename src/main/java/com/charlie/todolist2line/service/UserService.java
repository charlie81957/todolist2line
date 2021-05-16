package com.charlie.todolist2line.service;

import com.charlie.todolist2line.dto.UserInfoDto;

public interface UserService {
    
    String createUser(UserInfoDto userInfoDto);

    boolean isAbelToLogin(UserInfoDto userInfoDto);

}
