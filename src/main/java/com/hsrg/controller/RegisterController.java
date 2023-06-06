package com.hsrg.controller;

import com.hsrg.pojo.Auth;
import com.hsrg.pojo.Result;
import com.hsrg.service.RegisterService;
import com.hsrg.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody Auth auth){
        Auth auth1 = registerService.register(auth);
        if(auth1!=null){
            Map<String, Object> claims=new HashMap<>();
            claims.put("username",auth1.getUsername());
            claims.put("password",auth1.getPassword());
            claims.put("userId",auth1.getUserId());
            String jwt = JwtUtils.generateJwt(claims);
            Map data=new HashMap<>();
            data.put("token",jwt);
            data.put("userId",auth1.getUserId());
            return ResponseEntity.status(200).body(Result.success(data));
        }
        else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(Result.error("账号已被使用"));
        }
    }
}
