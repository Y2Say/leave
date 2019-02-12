package com.yj2.leave.controller;

import com.yj2.leave.entity.User;
import com.yj2.leave.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Enumeration;


@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    protected HttpSession httpSession;


    @PostMapping("/web/login")
    public User userLogin(@RequestBody User user) {
        User addUserInfo = userService.userLogin(user.getAccount(),user.getPassword());
        if (addUserInfo != null) {
            httpSession.setAttribute("user_id", addUserInfo.getId());
            return addUserInfo;
        } else {
            return null;
        }
    }
    /**
     * 退出登录
     *
     * @return
     */
    @GetMapping(value = "/logout")
    public String logout()  {
        Enumeration<String> eume = httpSession.getAttributeNames();
        while (eume.hasMoreElements()) {
            String name = eume.nextElement();
            httpSession.removeAttribute(name);
        }
        return "200";
    }

}
