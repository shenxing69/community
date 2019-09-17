package com.wan.communtify.mapper;

import com.wan.communtify.model.User;
import org.apache.ibatis.annotations.*;


@Mapper
public interface Usermapper {
    @Insert("insert into `user` (name,account_id,token,gmt_create,gmt_modified,avatar_url) values (#{name},#{accountId},#{token},#{gmt_create},#{gmt_modified},#{avatarUrl})")
    void insert(User user);
    @Select("select * from user where token=#{token}")
    User findByToken(@Param("token") String token);
    @Select("select * from user where id=#{id}")
    User findById(@Param("id")Integer id);
    @Select("select * from user where account_id =#{accountId}")
    User findByAccountId(String accountId);
    @Update("update user set name=#{name},token=#{token},avatar_url=#{avatarUrl},gmt_modified=#{gmt_modified} where id=#{id}")
    void update(User dbUser);
}
