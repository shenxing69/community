package com.wan.communtify.service;

import com.wan.communtify.mapper.Usermapper;
import com.wan.communtify.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private Usermapper usermapper;

    public void createOrUpdate(User user) {
        User dbUser=usermapper.findByAccountId(user.getAccountId());
        if(dbUser==null){
            //插入
            user.setGmt_create(System.currentTimeMillis());
            user.setGmt_modified(user.getGmt_create());
            usermapper.insert(user);
        }else {
            //更新
            dbUser.setGmt_modified(System.currentTimeMillis());
            dbUser.setAvatarUrl(user.getAvatarUrl());
            dbUser.setName(user.getName());
            dbUser.setToken(user.getToken());
            usermapper.update(dbUser);
        }
    }
}
