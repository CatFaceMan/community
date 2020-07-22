package com.pekah.mapper;

import com.pekah.model.Post;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PostMapper {
    @Insert("insert into post(login,title,content,tip,gmtCreate,gmtModified,accountId,avatarUrl) values(#{login},#{title},#{content},#{tip},#{gmtCreate},#{gmtModified},#{accountId},#{avatarUrl})")
    void insert(Post post);

    @Select("select * from post")
    List<Post> query();
}
