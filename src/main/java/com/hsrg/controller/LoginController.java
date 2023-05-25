package com.hsrg.controller;

import com.hsrg.pojo.Auth;
import com.hsrg.pojo.Result;
import com.hsrg.service.LoginService;
import com.hsrg.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody Auth auth){
        Auth auth1= loginService.login(auth);
        if(auth1!=null){
            Map<String, Object> claims=new HashMap<>();
            claims.put("username",auth1.getUsername());
            claims.put("userId",auth1.getUserId());
            claims.put("isAdmin",auth1.getIsAdmin());
            String jwt = JwtUtils.generateJwt(claims);
            Map data=new HashMap<>();
            data.put("token",jwt);
            return ResponseEntity.status(200).body(Result.success(data));
        }
        else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(Result.error("用户名或密码错误"));
        }
    }

    @PostMapping("/adminLogin")
    public ResponseEntity adminLogin(@RequestBody Auth auth){
        Auth auth1=loginService.adminLogin(auth);
        if(auth1!=null){
            Map<String, Object> claims=new HashMap<>();
            claims.put("username",auth1.getUsername());
            claims.put("userId",auth1.getUserId());
            claims.put("isAdmin",auth1.getIsAdmin());
            String jwt = JwtUtils.generateJwt(claims);
            Map data=new HashMap<>();
            data.put("token",jwt);
            return ResponseEntity.status(200).body(Result.success(data));
        }
        else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(Result.error("无法进行管理员登录"));
        }
    }
}
