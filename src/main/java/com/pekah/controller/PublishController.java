package com.pekah.controller;

import com.pekah.mapper.PostMapper;
import com.pekah.model.Post;
import com.pekah.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class PublishController {

    @GetMapping("/publish")
    public String publish() {
        return "publish";
    }

    @Autowired(required = false)
    private PostMapper postMapper;

    @PostMapping("/publish")
    public String doPublish(
            @RequestParam(name = "title") String title,
            @RequestParam(name = "content") String content,
            @RequestParam(name = "tip") String tip, HttpServletRequest req, Model model) {
        User user = (User) req.getSession().getAttribute("user");
        model.addAttribute("title", title);
        model.addAttribute("content", content);
        model.addAttribute("tip", tip);
        if (user == null) {
            model.addAttribute("error", "您还未登录");
            return "publish";
        }
        if (title == null || title == "") {
            model.addAttribute("error", "标题不能为空！");
            return "publish";
        }
        if (content == null || content == "") {
            model.addAttribute("error", "内容不能为空！");
            return "publish";
        }
        if (tip == null || tip == "") {
            model.addAttribute("error", "标签不能为空");
            return "publish";
        } else {
            Post post = new Post();
            post.setLogin(user.getLogin());
            Date dNow = new Date();
            SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            post.setTitle(title);
            post.setContent(content);
            post.setTip(tip);
            post.setAccountId(user.getAccountId());
            post.setGmtCreate(ft.format(dNow));
            post.setGmtModified(ft.format(dNow));
            post.setAvatarUrl(user.getAvatarUrl());
            postMapper.insert(post);
            return "redirect:/";
        }
    }
}
