package com.hsrg.controller;


import com.hsrg.pojo.Auth;
import com.hsrg.pojo.Result;
import com.hsrg.pojo.User;
import com.hsrg.service.AdminActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AdminActionController {

    @Autowired
    private AdminActionService adminActionService;

    @PostMapping("/logOff")
    public ResponseEntity logOff(@RequestBody User user){
        adminActionService.logOff(user);
        return ResponseEntity.status(200).body(Result.success());
    }

    @PostMapping("/queryIsAdmin")
    public Result queryIsAdmin(@RequestBody Auth auth){
        return Result.success(adminActionService.queryIsAdmin(auth.getUserId()));
    }

    @PostMapping("/setIsAdmin")
    public Result setIsAdmin(@RequestBody Auth auth){
        return Result.success(adminActionService.setIsAdmin(auth));
    }

    @PostMapping("/resetPassword")
    public Result resetPassword(@RequestBody Auth auth, @RequestHeader("Authorization")String jwt){
        adminActionService.resetPassword(auth,jwt);
        return Result.success();
    }

}
