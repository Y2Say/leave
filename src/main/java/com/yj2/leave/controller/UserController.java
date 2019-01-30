package com.yj2.leave.controller;

import com.yj2.leave.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {



    @RequestMapping("/{id}")
    public String  getUser(@PathVariable Integer id, Model model) {

        User user = new User();
        user.setAccount("1234");
        user.setName("yj2");
        model.addAttribute("user",user);
        return "user/detail";
    }

    @RequestMapping("/list")
    public String  listUser(Model model) {
        List<User> userList = new ArrayList<User>();
        for (int i = 0; i <10; i++) {
            User user = new User();
            user.setAccount("1234");
            user.setName("yj2");
            userList.add(user);
        }

        model.addAttribute("users", userList);
        return "user/list";
    }
}
