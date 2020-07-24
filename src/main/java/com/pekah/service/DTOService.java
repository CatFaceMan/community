package com.pekah.service;

import com.pekah.dto.PageDTO;
import com.pekah.dto.PostDTO;
import com.pekah.mapper.PostMapper;
import com.pekah.mapper.UserMapper;
import com.pekah.model.Post;
import com.pekah.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DTOService {

    @Autowired(required = false)
    private PostMapper postMapper;

    @Autowired(required = false)
    private UserMapper userMapper;

    /**
     * 这么写主要是为了演示两个表合一个表，但是因为user表的特殊关系，这么写不合适，存在逻辑障碍。
     * @return
     * @param page
     * @param size
     */

    public PageDTO getPost(Integer page, Integer size) {
		Integer offset = (page-1) * size;
        List<Post> postList = (List<Post>) postMapper.limit(offset,size);
        List<PostDTO> postDTOList = new ArrayList<>();
        PageDTO pageDTO = new PageDTO();
        for (Post post : postList) {
            User user = userMapper.findById(post.getAccountId());
            PostDTO postDTO = new PostDTO();
            BeanUtils.copyProperties(post, postDTO);
            postDTO.setUser(user);
            postDTOList.add(postDTO);
        }
        pageDTO.setPostDTOList(postDTOList);
        Integer sum = postMapper.sum();
        pageDTO.back(sum,page,size);
        return pageDTO;
    }
}
