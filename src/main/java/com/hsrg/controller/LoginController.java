package com.hsrg.controller;

import com.hsrg.pojo.Auth;
import com.hsrg.pojo.Result;
import com.hsrg.service.AuthService;
import com.hsrg.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class LoginController {

    @Autowired
    private AuthService loginService;

    @PostMapping("/login")
    public Result login(@RequestBody Auth auth){
        Auth auth1= loginService.login(auth);
        if(auth1!=null){
            Map<String, Object> claims=new HashMap<>();

            claims.put("email",auth1.getEmail());
            claims.put("password",auth1.getPassword());
            claims.put("userId",auth1.getUserId());
            claims.put("isAdmin",auth1.getIsAdmin());
            String jwt = JwtUtils.generateJwt(claims);
            return Result.success(jwt);
        }
        return Result.error("邮箱或密码错误");
    }
}
