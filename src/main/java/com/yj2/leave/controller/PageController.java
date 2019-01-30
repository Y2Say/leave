package com.yj2.leave.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PageController {
    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("title", "This is your message");
        return "index";
    }

    @RequestMapping("/login")
    public String login(Model model) {
        model.addAttribute("title1", "This is your message1");
        return "common/login";
    }
    @RequestMapping("/user_list")
    public String userList(Model model) {
        model.addAttribute("title", "This is your message");
        return "user/list";
    }

    @RequestMapping("/user_detail")
    public String userDetail(Model model) {
        model.addAttribute("title1", "This is your message1");
        return "user/detail";
    }
}
