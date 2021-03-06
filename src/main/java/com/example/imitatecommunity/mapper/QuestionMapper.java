package com.example.imitatecommunity.mapper;

import com.example.imitatecommunity.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.awt.*;
import java.util.List;

/**
 * @description:
 * @author: MGZ
 * @createDate: 2019/12/24
 */
@Mapper
public interface QuestionMapper {
    @Insert("insert into question (title,description,gmt_created,gmt_modified,creator,tag) values (#{title},#{description},#{gmtCreated},#{gmtModified},#{creator},#{tag})")
    void create(Question question);

    @Select("select * from question limit #{offset},#{size}")
    List<Question> list(@Param("offset") Integer offset, @Param("size") Integer size);

    @Select("select count(1) from question")
    Integer count();

    @Select("select * from question where creator = #{userId} limit #{offset},#{size}")
    List<Question> listByCreator(@Param("userId") Integer userId,@Param("offset") Integer offset, @Param("size") Integer size);

    @Select("select count(1) from question where creator = #{userId}")
    Integer countByUserId(@Param("userId") Integer userId);

    @Select("select * from question where id = #{id}")
    Question getById(@Param("id") Integer id);
}
