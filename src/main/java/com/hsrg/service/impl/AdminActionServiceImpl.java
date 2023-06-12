package com.hsrg.service.impl;

import com.hsrg.clients.UserClient;
import com.hsrg.mapper.AuthDelete;
import com.hsrg.mapper.AuthSelect;
import com.hsrg.mapper.AuthUpdate;
import com.hsrg.pojo.Auth;
import com.hsrg.pojo.User;
import com.hsrg.service.AdminActionService;
import com.hsrg.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminActionServiceImpl implements AdminActionService {

    @Autowired
    private UserClient userClient;
    @Autowired
    private AuthDelete authDelete;
    @Autowired
    private AuthSelect authSelect;
    @Autowired
    private AuthUpdate authUpdate;

    @Override
    public void logOff(User user) {
        authDelete.deleteAuthByUserId(user.getUserId().toString());
        userClient.deleteOneUser(new User(user.getUserId(),null,null,null,null,null));
    }

    @Override
    public Boolean queryIsAdmin(Long userId) {
        return authSelect.getIsAdminByUserId(userId);
    }

    @Override
    public Boolean setIsAdmin(Auth auth) {
        authUpdate.updateIsAdminByUserId(auth);
        return authSelect.getIsAdminByUserId(auth.getUserId());
    }

    @Override
    public void resetPassword(Auth auth, String jwt) {
        Claims claims = JwtUtils.parseJWT(jwt);
        authUpdate.updatePassword(auth.getPassword(),(Long)claims.get("userId"));
    }
}
