package com.pekah.model;

import lombok.Data;

@Data
public class User {
    private String id;
    private String accountId;
    private String login;
    private String token;
    private String gmtCreate;
    private String gmtModified;
    private String bio;
    private String avatarUrl;
}
