package com.yj2.leave.service.impl;

import com.yj2.leave.entity.User;
import com.yj2.leave.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.yj2.leave.service.impl.UserServiceImpl")
public class UserServiceImpl implements UserService {

    /**
     * 用户登录
     * @param userName
     * @param password
     * @return
     */
    @Override
    @Transactional
    public User userLogin(String userName, String password) {

        return null;
    }

}
