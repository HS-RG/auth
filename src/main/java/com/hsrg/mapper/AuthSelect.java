package com.hsrg.mapper;

import com.hsrg.pojo.Auth;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AuthSelect {

    @Select("select * from auth where username=#{username} and password=#{password}")
    Auth getByUsernameAndPassword(Auth auth);

    @Select("select * from auth where username=#{username}")
    Auth getByUsername(Auth auth);

    @Select("select * from auth where username=#{username} and password=#{password} and is_admin=1")
    Auth getAdminByUsernameAndPassword(Auth auth);

    @Select("select is_admin from auth where user_id=#{userId}")
    Boolean getIsAdminByUserId(Long userId);
}
