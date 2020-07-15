package com.pekah.controller;

import com.pekah.dto.AccessTokenDTO;
import com.pekah.dto.GithubUser;
import com.pekah.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;


    @Value("${AccessTokenDTO.client.id}")
    private String client_id;
    @Value("${AccessTokenDTO.client.secret}")
    private String client_secret;
    @Value("${AccessTokenDTO.redirect.uri}")
    private String redirect_uri;


    @GetMapping("/callback")
    public String callback(@RequestParam(name="code")String code,
                           @RequestParam(name="state")String state, HttpServletRequest req) {
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(client_id);
        accessTokenDTO.setClient_secret(client_secret);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri(redirect_uri);
        accessTokenDTO.setState(state);
        String Token = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser user= githubProvider.getGithubUser(Token);
        if(user != null){
            req.getSession().setAttribute("user",user);
            return "redirect:/";
        }
        else{
            return "redirect:/";
        }
    }
}
