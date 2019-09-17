package com.wan.communtify.mapper;


import com.wan.communtify.dto.QuestionDTO;
import com.wan.communtify.model.Question;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface QuestionMapper {
    @Insert("insert into question (title,description,gmt_create,gmt_modified,creator,tag) values (#{title},#{description},#{gmtCreate},#{gmtModified},#{creator},#{tag})")
    void create(Question question);
    @Select("Select * from question limit #{offset},#{size}")
    List<Question> list(@Param("offset") Integer offset, @Param("size") Integer size);
    @Select("select count(1) from question")
    Integer count();
    @Select("Select * from question where creator=#{userId} limit #{offset},#{size}")
    List<Question> listByUerId(@Param("userId")int userId, @Param("offset")Integer offset, @Param("size")Integer size);
    @Select("select count(1)  from question where creator=#{userId}")
    Integer countByuserId(int userId);
    @Select("select * from question where id=#{id}")
    Question findById(Integer id);
    @Update("update question set title=#{title},description=#{description},gmt_modified=#{gmtModified},tag=#{tag} where id=#{id}")
    void update(Question question);
}
