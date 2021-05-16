package com.charlie.todolist2line.service.impl;

import java.util.Optional;

import com.charlie.todolist2line.dto.UserInfoDto;
import com.charlie.todolist2line.mapper.UserInfoMapper;
import com.charlie.todolist2line.model.UserInfo;
import com.charlie.todolist2line.service.UserService;
import com.charlie.todolist2line.utils.SHA256Utils;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpe implements UserService {

    private UserInfoMapper userInfoMapper;

    @Override
    public String createUser(UserInfoDto userInfoDto) {
        Optional<UserInfo> optionalUser = userInfoMapper.findUserById(userInfoDto.getUserId());
        if (!optionalUser.isPresent()) {
            return "exsistUser";
        }

        UserInfo userInfo = new UserInfo();

        BeanUtils.copyProperties(userInfoDto, userInfo);

        String encryptionPassword = SHA256Utils.getSHA256(userInfoDto.getUserId() + userInfoDto.getUserPassword());
        userInfo.setEncryptedPassword(encryptionPassword);

        userInfoMapper.insertUser(userInfo);

        return "success";
    }

    @Override
    public boolean isAbelToLogin(UserInfoDto userInfoDto) {
        Optional<UserInfo> optionalUser = userInfoMapper.findUserById(userInfoDto.getUserId());
        if (optionalUser.isPresent()) {
            return false;
        }

        String encryptionPassword = SHA256Utils.getSHA256(userInfoDto.getUserId() + userInfoDto.getUserPassword());
        UserInfo userInfo = new UserInfo(userInfoDto.getUserId(), encryptionPassword);

        if (optionalUser.get().equals(userInfo)) {
            return true;
        } else {
            return false;
        }
    }

}
