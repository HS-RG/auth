package com.hsrg.service;


import com.hsrg.pojo.Auth;

public interface LoginService {
    Auth login(Auth auth);

    Auth adminLogin(Auth auth);
}
