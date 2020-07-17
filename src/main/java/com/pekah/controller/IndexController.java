package com.pekah.controller;

import com.pekah.dto.GithubUser;
import com.pekah.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {

    @Autowired(required = false)
    private UserMapper userMapper;

    @GetMapping("/")
    public String index(HttpServletRequest req){
        Cookie[] cookies = req.getCookies();
        for(Cookie cookie : cookies){
            if (cookie.getName().equals("token")){
                String token = cookie.getValue();
                GithubUser user = userMapper.findByToken(token);
                if(user!=null){
                    req.getSession().setAttribute("user",user);
                }
            }
        }
        return "index";
    }
}
