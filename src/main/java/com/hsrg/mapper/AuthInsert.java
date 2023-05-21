package com.hsrg.mapper;

import com.hsrg.pojo.Auth;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AuthInsert {

    @Insert("insert into auth(user_id, username, password, is_admin, update_time, create_time) " +
            "VALUES (#{userId},#{username},#{password},#{isAdmin},#{updateTime},#{createTime})")
    void insertAuth(Auth auth);
}
