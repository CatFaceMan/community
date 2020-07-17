package com.pekah.controller;

import com.pekah.dto.AccessTokenDTO;
import com.pekah.dto.GithubUser;
import com.pekah.mapper.UserMapper;
import com.pekah.model.User;
import com.pekah.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

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

    @Autowired(required=false)
    private UserMapper userMapper;

    @GetMapping("/callback")
    public String callback(@RequestParam(name="code")String code,
                           @RequestParam(name="state")String state, HttpServletResponse resp) throws IOException {
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(client_id);
        accessTokenDTO.setClient_secret(client_secret);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri(redirect_uri);
        accessTokenDTO.setState(state);
        String Token = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser githubUser= githubProvider.getGithubUser(Token);
        if(githubUser != null){
            User user = new User();
            Date dNow = new Date( );
            SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
            user.setGmtCreate(ft.format(dNow));
            user.setGmtModified(user.getGmtCreate());
            user.setAccountId(String.valueOf(githubUser.getId()));
            user.setLogin(githubUser.getLogin());
            String token = UUID.randomUUID().toString();
            user.setToken(token);
            userMapper.insert(user);
            resp.addCookie(new Cookie("token",token));
            return "redirect:/";
        }
        else{
            return "redirect:/";
        }
    }
}
