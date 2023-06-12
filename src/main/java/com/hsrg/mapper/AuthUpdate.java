package com.hsrg.mapper;

import com.hsrg.pojo.Auth;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface AuthUpdate {
    @Update("update auth set is_admin=#{isAdmin} where user_id=#{userId}")
    void updateIsAdminByUserId(Auth auth);

    @Update("update auth set password=#{password} where user_id=#{userId}")
    void updatePassword(String password, Long userId);
}
