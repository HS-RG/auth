package com.hsrg.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Auth {
    private Long userId;
    private String username;
    private String password;
    private Boolean isAdmin;
    private LocalDateTime updateTime;
    private LocalDateTime createTime;
}
