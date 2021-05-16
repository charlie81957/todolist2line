package com.charlie.service;

import com.charlie.todolist2line.dto.UserInfoDto;

public interface UserService {
    void createUser(UserInfoDto userInfoDto);

    boolean isAbelToLogin(UserInfoDto userInfoDto);

    boolean CreateUser(UserInfoDto userInfoDto);

    void logout();
    
    UserInfoDto findUserById(String userId);

    boolean deleteUserById(String userId);

    void updateUser(UserInfoDto userInfoDto);
}
