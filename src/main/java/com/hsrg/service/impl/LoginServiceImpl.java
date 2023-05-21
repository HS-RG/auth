package com.hsrg.service.impl;

import com.hsrg.mapper.AuthSelect;
import com.hsrg.pojo.Auth;
import com.hsrg.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AuthSelect authSelect;

    @Override
    public Auth login(Auth auth) {
        return authSelect.getByUsernameAndPassword(auth);
    }

    @Override
    public Auth adminLogin(Auth auth) {
        return authSelect.getAdminByUsernameAndPassword(auth);
    }
}
