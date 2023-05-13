package com.hsrg.service.impl;

import com.hsrg.mapper.AuthMapper;
import com.hsrg.pojo.Auth;
import com.hsrg.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthMapper authMapper;

    @Override
    public Auth login(Auth auth) {
        return authMapper.getByEmailAndPassword(auth);
    }
}
