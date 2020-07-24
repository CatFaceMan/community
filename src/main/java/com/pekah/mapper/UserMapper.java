package com.pekah.mapper;

import com.pekah.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;


public interface UserMapper {
    @Insert("Insert into user (accountId, login , token , gmtCreate , gmtModified , bio,avatarUrl) values(#{accountId},#{login},#{token},#{gmtCreate},#{gmtModified},#{bio},#{avatarUrl})")
    void insert(User user);

    @Select("select * from user where token=#{token}")
    User findByToken(String token);

    @Select("select * from user where accountId=#{accountId}")
    User findById(String accountId);

}
