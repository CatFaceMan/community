package com.pekah.dto;

import com.pekah.model.User;
import lombok.Data;

@Data
public class PostDTO {
    private String id;
    private String login;
    private String title;
    private String content;
    private String tip;
    private String accountId;
    private String gmtCreate;
    private String gmtModified;
    private String commentCount;
    private String viewCount;
    private String likeCount;
    private String tag;
    private String avatarUrl;
    private User user;
}
