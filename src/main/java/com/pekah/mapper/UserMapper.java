package com.pekah.mapper;

import com.pekah.model.User;
import org.apache.ibatis.annotations.*;

public interface UserMapper {
    @Insert("Insert into user (account_id,name , token , gmt_create , gmt_modified) values(#{accountId},#{name},#{token},#{gmtCreate},#{gmtModified})")
    void insert(User user);
}
