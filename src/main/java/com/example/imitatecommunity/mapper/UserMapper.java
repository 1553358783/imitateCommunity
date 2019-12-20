package com.example.imitatecommunity.mapper;

import com.example.imitatecommunity.dto.GithubUser;
import com.example.imitatecommunity.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Insert("insert into user (account_id,name,token,gmt_created,gmt_modified) values (#{accountId},#{name},#{token},#{gmtCreated},#{gmtModified})")
    void insert(User user);

    @Select("select * from user where token = #{token}")
    User findByToken(@Param("token") String token);
}