package com.yj2.leave.controller;

import lombok.Data;

@Data
public class UserInfoBean {
    private String id;
    private String account;
    private String name;
    private String salt;
    private String password;
    private String power;//菜单列表
}
