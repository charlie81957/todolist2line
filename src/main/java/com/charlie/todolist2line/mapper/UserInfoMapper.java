package com.charlie.todolist2line.mapper;

import java.util.Optional;

import com.charlie.todolist2line.model.UserInfo;

public interface UserInfoMapper {
    Optional<UserInfo> findUserById(String userId);
    
    void insertUser(UserInfo User);

    void deleteUserById(String userId);

    void updateUser(UserInfo userInfo);
}
