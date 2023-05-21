package com.hsrg.service.impl;

import com.hsrg.clients.UserClient;
import com.hsrg.mapper.AuthInsert;
import com.hsrg.mapper.AuthSelect;
import com.hsrg.pojo.Auth;
import com.hsrg.pojo.User;
import com.hsrg.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wiki.xsx.core.snowflake.config.Snowflake;

import java.time.LocalDateTime;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private AuthSelect authSelect;
    @Autowired
    private AuthInsert authInsert;
    @Autowired
    private Snowflake snowflake;
    @Autowired
    private UserClient userClient;
    @Override
    public Auth register(Auth auth) {
        if(authSelect.getByUsername(auth)==null){
            auth.setCreateTime(LocalDateTime.now());
            auth.setUpdateTime(LocalDateTime.now());
            auth.setIsAdmin(false);
            auth.setUserId(snowflake.nextId());
            authInsert.insertAuth(auth);
            User user = new User(auth.getUserId(),auth.getUsername(),null,auth.getUpdateTime(),auth.getCreateTime());
            userClient.initOneUser(user);
            return auth;
        }
        return null;
    }
}
