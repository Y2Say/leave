package com.yj2.leave.controller;

import com.alibaba.fastjson.JSON;
import com.yj2.leave.entity.User;
import com.yj2.leave.exception.ControllerException;
import com.yj2.leave.exception.ExceptionEnum;
import com.yj2.leave.service.UserService;
import com.yj2.leave.util.TokenUtil;
import com.yj2.leave.util.aop.RequireLogin;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String register(@RequestParam("account") String account,@RequestParam("name") String name,@RequestParam("role") String role){
        String token = request.getHeader("x-auth-token");
        if(StringUtils.isEmpty(token)){
            throw new ControllerException(ExceptionEnum.ERROR_TOKEN);
        }
        if(StringUtils.isEmpty(account) || StringUtils.isEmpty(name) || StringUtils.isEmpty(role)){
            throw new ControllerException(ExceptionEnum.INFO_NULL);
        }
        HashMap<String,Object> map = new HashMap<String,Object>();

        String systemId = TokenUtil.getAccountIdByToken(token);
        userService.register(systemId, account, name, role);
        map.put("message","添加成功！");
        return JSON.toJSONString(map);
    }

    @RequireLogin
    @PutMapping("/update_password")
    @ApiOperation("修改密码")
    public String updatePassword(@RequestParam("password") String password) {
        String token = request.getHeader("x-auth-token");

        if(StringUtils.isEmpty(token)){
            throw new ControllerException(ExceptionEnum.ERROR_TOKEN);
        }
        if(StringUtils.isEmpty(password)){
            throw new ControllerException(ExceptionEnum.ERROR＿PASSWORD);
        }
        if(password.length()<6 || password.length()>18){
            throw new ControllerException(ExceptionEnum.PASSWORD_ERROE);
        }
        HashMap<String,Object> map = new HashMap<String,Object>();

        String managerId = TokenUtil.getAccountIdByToken(token);
        userService.updatePassword(managerId, password);
        map.put("message","修改成功！");
        return JSON.toJSONString(map);
    }

}
