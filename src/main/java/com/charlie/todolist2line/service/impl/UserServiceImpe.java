package com.charlie.todolist2line.service.impl;

import java.util.NoSuchElementException;
import java.util.Optional;

import com.charlie.todolist2line.dto.UserInfoDto;
import com.charlie.todolist2line.model.UserInfo;
import com.charlie.todolist2line.repo.UserRepository;
import com.charlie.todolist2line.service.UserService;
import com.charlie.todolist2line.utils.SHA256Utils;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpe implements UserService {

    @Autowired
    private UserRepository userRepo;

    /**
     * ユーザの検索
     * 
     * @param id
     * @return
     */
    @Override
    public UserInfo findUserById(String id) {
        try {
            return userRepo.findById(id).get();
        } catch (NoSuchElementException e) {
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * ログイン時のレコード存在確認およびパスワード一致確認
     */
    @Override
    public boolean isAbleToLogin(UserInfoDto userInfoDto) {
        Optional<UserInfo> optionalUser = userRepo.findById(userInfoDto.getUserId());
        if (!optionalUser.isPresent()) {
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

    /**
     * ユーザの新規登録
     */
    @Override
    public String createUser(UserInfoDto userInfoDto) {
        Optional<UserInfo> optionalUser = userRepo.findById(userInfoDto.getUserId());
        if (optionalUser.isPresent()) {
            return "exsistUser";
        }

        UserInfo userInfo = new UserInfo();

        BeanUtils.copyProperties(userInfoDto, userInfo);

        String encryptionPassword = SHA256Utils.getSHA256(userInfoDto.getUserId() + userInfoDto.getUserPassword());
        userInfo.setEncryptedPassword(encryptionPassword);

        userRepo.save(userInfo);

        return "success";
    }

    /**
     * ユーザ情報の更新
     * 
     * @param user
     * @return
     */
    @Override
    public String updateUser(UserInfo user) {
        try {
            userRepo.save(user);
            return user.getUserId() + "was updated.";
        } catch (Exception e) {
            return "System error happened.";
        }
    }

    /**
     * ユーザ情報の削除
     * 
     * @param id
     * @return
     */
    @Override
    public String deleteUser(String id) {
        try {
            userRepo.deleteById(id);
            return id + "was deleted.";
        } catch (Exception e) {
            return "System error happened.";
        }
    }

}
