package com.hsrg.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface AuthDelete {

    @Update("update auth set username=#{userId}")
    void deleteAuthByUserId(String userId);
}
