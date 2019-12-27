package com.example.imitatecommunity.mapper;

import com.example.imitatecommunity.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
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

    @Select("select * from question")
        List<Question> list();
}
