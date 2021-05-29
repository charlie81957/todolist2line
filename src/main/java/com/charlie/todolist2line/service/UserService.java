package com.charlie.todolist2line.service;

import com.charlie.todolist2line.dto.UserInfoDto;
import com.charlie.todolist2line.model.UserInfo;

public interface UserService {

    String createUser(UserInfoDto userInfoDto);

    boolean isAbleToLogin(UserInfoDto userInfoDto);

    boolean isExistUserId(String userId);

    UserInfoDto findUserById(String id);

    String updateUser(UserInfo user);

    String deleteUser(String id);
}
