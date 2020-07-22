package com.pekah.dto;

import lombok.Data;

@Data
public class GithubUser {
    private String login;
    private String id;
    private String accountId;
    private String bio;
    private String avatarUrl;

}
