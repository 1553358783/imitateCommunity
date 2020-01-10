package com.example.imitatecommunity.mapper;

import com.example.imitatecommunity.dto.GithubUser;
import com.example.imitatecommunity.model.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    @Insert("insert into user (account_id,name,token,gmt_created,gmt_modified,avatar_url) values (#{accountId},#{name},#{token},#{gmtCreated},#{gmtModified},#{avatarUrl})")
    void insert(User user);

    @Select("select * from user where token = #{token}")
    User findByToken(@Param("token") String token);

    @Select("select * from user where id = #{id}")
    User findById(@Param("id") Integer id);

    @Select("select * from user where account_id = #{accountId}")
    User findByAccountId(@Param("accountId") String accountId);

    @Update("update user set name = #{name} , token = #{token} , gmt_modified = #{gmtModified} , avatar_url = #{avatarUrl} where id = #{id}")
    void update(User user);
}
