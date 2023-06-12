package com.hsrg.service;

import com.hsrg.pojo.Auth;
import com.hsrg.pojo.User;

public interface AdminActionService {
    void logOff(User user);

    Boolean queryIsAdmin(Long userId);

    Boolean setIsAdmin(Auth auth);

    void resetPassword(Auth auth, String jwt);
}
