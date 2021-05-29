package com.charlie.todolist2line.service;

import com.charlie.todolist2line.dto.UserInfoDto;

public interface UserService {

    String createUser(UserInfoDto userInfoDto);

    boolean isAbleToLogin(UserInfoDto userInfoDto);

    boolean isExistUserId(String userId);

    UserInfoDto findUserById(String id);

    String updateUser(UserInfoDto  userInfoDto);

    String deleteUser(String id);
}
