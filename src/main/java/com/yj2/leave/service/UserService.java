package com.yj2.leave.service;


import com.yj2.leave.entity.User;

public interface UserService {

    /**
     * 用户登录验证
     * @param userName
     * @param password
     * @return
     */
    User userLogin(String userName, String password);

    /**
     * 运营人员新增用户
     * @param systemId
     * @param account
     * @param name
     * @param role
     */
    void register(String systemId, String account, String name, String role);

    /**
     * 修改密码
     * @param userId
     * @param password
     */
    void updatePassword(String userId,String password);

}
