package com.pekah.controller;

import com.pekah.dto.AccessTokenDTO;
import com.pekah.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;

    @GetMapping("/callback")
    public String callback(@RequestParam(name="code")String code,
                            @RequestParam(name="state")String state) {
        /*AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id("a60788f8a953b9efbd67");
        accessTokenDTO.setClient_secret("16e0e7d77edbd2d5d639bbf3e0d8b56e4b81a1a3");
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri("https://github.com/login/oauth/authorize");
        accessTokenDTO.setState(state);
        githubProvider.getAccessToken(accessTokenDTO);*/
        return "index";
    }
}
