package com.wan.communtify.mapper;

import com.wan.communtify.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface Usermapper {
    @Insert("insert into `user` (name,account_id,token,gmt_create,gmt_modified) values (#{name},#{accountId},#{token},#{gmt_create},#{gmt_modified})")
    void insert(User user);
}
