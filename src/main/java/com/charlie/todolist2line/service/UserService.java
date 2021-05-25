package com.charlie.todolist2line.service;

import com.charlie.todolist2line.dto.UserInfoDto;

public interface UserService {

    String createUser(UserInfoDto userInfoDto);

    boolean isAbleToLogin(UserInfoDto userInfoDto);

    UserInfoDto findUserById(String id);

    String updateUser(UserInfoDto  userInfoDto);

    String deleteUser(String id);
}
