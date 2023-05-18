package com.hsrg.mapper;

import com.hsrg.pojo.Auth;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AuthMapper {

    @Select("select * from auth where username=#{username} and password=#{password}")
    Auth getByEmailAndPassword(Auth auth);
}
