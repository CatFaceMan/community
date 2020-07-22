package com.pekah.controller;

import com.pekah.dto.PostDTO;
import com.pekah.mapper.UserMapper;
import com.pekah.model.User;
import com.pekah.service.DTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class IndexController {

    @Autowired(required = false)
    private UserMapper userMapper;
    
    @Autowired(required = false)
    private DTOService dtoService;

    @GetMapping("/")
    public String index(HttpServletRequest req, Model model){
        Cookie[] cookies = req.getCookies();
        if(cookies!=null){
            for(Cookie cookie : cookies){
                if (cookie.getName().equals("token")){
                    String token = cookie.getValue();
                    User user = userMapper.findByToken(token);
                    if(user!=null){
                        req.getSession().setAttribute("user",user);
                    }
                }
            }
        }
        List<PostDTO> postList = dtoService.getPost();
        model.addAttribute("postList",postList);
        return "index";
    }
}
