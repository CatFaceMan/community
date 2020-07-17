package com.pekah.mapper;

import com.pekah.dto.GithubUser;
import com.pekah.model.User;
import org.apache.ibatis.annotations.*;

public interface UserMapper {
    @Insert("Insert into user (account_id, login , token , gmt_create , gmt_modified , bio) values(#{accountId},#{login},#{token},#{gmtCreate},#{gmtModified},#{bio})")
    void insert(User user);

    @Select("select * from user where token = #{token}")
    GithubUser findByToken(String token);
}
