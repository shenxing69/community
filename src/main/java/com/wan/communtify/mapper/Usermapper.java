package com.wan.communtify.mapper;

import com.wan.communtify.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface Usermapper {
    @Insert("insert into `user` (name,account_id,token,gmt_create,gmt_modified) values (#{name},#{accountId},#{token},#{gmt_create},#{gmt_modified})")
    void insert(User user);
    @Select("select * from user where token=#{token}")
    User findByToken(@Param("token") String token);
}
