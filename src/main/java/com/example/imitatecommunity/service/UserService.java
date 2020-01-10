package com.example.imitatecommunity.service;

import com.example.imitatecommunity.mapper.UserMapper;
import com.example.imitatecommunity.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: MGZ
 * @createDate: 2020/1/6
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    public void insertOrUpdate(User user) {
        User dbuser = userMapper.findByAccountId(user.getAccountId());
        if(dbuser == null){
            user.setGmtCreated(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreated());
            userMapper.insert(user);
        }else{
           dbuser.setGmtModified(System.currentTimeMillis());
           dbuser.setAvatarUrl(user.getAvatarUrl());
           dbuser.setToken(user.getToken());
           dbuser.setName(user.getName());
           userMapper.update(dbuser);
        }
    }
}
