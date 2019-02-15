package com.yj2.leave.service.impl;

import com.yj2.leave.controller.UserInfoBean;
import com.yj2.leave.entity.*;
import com.yj2.leave.exception.ExceptionEnum;
import com.yj2.leave.exception.ServiceException;
import com.yj2.leave.mapper.*;
import com.yj2.leave.service.UserService;
import com.yj2.leave.util.EncryDigestUtil;
import com.yj2.leave.util.TokenUtil;
import com.yj2.leave.util.UUIDUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Log4j2
@Service("com.yj2.leave.service.impl.UserServiceImpl")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserDefinedMapper userDefinedMapper;

    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private PermissionDefinedMapper permissionDefinedMapper;

    @Autowired
    private UserRoleDefinedMapper userRoleDefinedMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private MenuDefinedMapper menuDefinedMapper;



    /**
     * 用户登录
     * @param account
     * @param password
     * @return
     */
    @Override
    @Transactional
    public UserInfoBean userLogin(String account, String password) {

        User user = userDefinedMapper.queryUserByAccount(account);
        if (user==null) {
            throw new ServiceException(ExceptionEnum.NOT_EXIST);
        }
        int status = user.getStatus();
        if(status==0||status==1){
            String ps = user.getPassword();
            if (!ps.equals(EncryDigestUtil.digest(password))) {
                throw new ServiceException(ExceptionEnum.ERROR＿PASSWORD);
            }
            //生成token
            String token;
            try {
                token = TokenUtil.createJwt(user.getId());
            } catch (ServiceException e) {
                throw new ServiceException(ExceptionEnum.ERROE_CREATE_TOKEN);
            }
            //保存token
            user.setSalt(token);

            userMapper.updateByPrimaryKeySelective(user);
            List<Menu> menus = getUserPermTree(user);
            UserInfoBean userInfoBean = new UserInfoBean();
            userInfoBean.setId(user.getId());
            userInfoBean.setAccount(user.getAccount());
            userInfoBean.setSalt(user.getSalt());
            userInfoBean.setPower(menus.toString());
            return userInfoBean;
        }else{
            throw new ServiceException(ExceptionEnum.NOT_EXIST);
        }
    }

    @Override
    @Transactional
    public void register(String systemId, String account, String name, String departmentId,String roleId) {
        User user1 = userDefinedMapper.queryUserByAccount(account);
        if(user1!=null){
            throw new ServiceException(ExceptionEnum.ACCOUNT_EXIST);
        }
        //添加用户
        User user = new User();
        String userId = UUIDUtil.randomString();

        user.setId(userId);
        user.setAccount(account);
        user.setName(name);
        user.setStatus(0);
        user.setDepartmentId(departmentId);
        user.setPassword(EncryDigestUtil.digest("123123"));//默认密码
        user.setCreatedBy(systemId);
        user.setCreateTime(new Date());
        userMapper.insert(user);

        //添加角色
        UserRole userRole = new UserRole();
        userRole.setUserId(userId);
        userRole.setRoleId(roleId);
        userRole.setCreateTime(new Date());
        userRoleMapper.insert(userRole);
        //添加权限

    }

    @Override
    public void updatePassword(String userId, String password) {
        User user = userMapper.selectByPrimaryKey(userId);
        if(user!=null){
            user.setPassword(EncryDigestUtil.digest(password));
            user.setUpdateTime(new Date());
            user.setUpdatedBy(userId);
            userMapper.updateByPrimaryKeySelective(user);
        }
    }

    /**
     * 生成用户的资源权限的树结构
     * @param
     * @return
     */
    public List<Menu> getUserPermTree(User user){
        log.info("===生成用户的资源权限的树结构===");

        //获取用户所有角色
        List<String> roles=userRoleDefinedMapper.queryRoleIdsByUserId(user.getId());
        //获取用户所有权限菜单Ids
        List<String> menuIds=permissionDefinedMapper.queryMenuIdsByRoleIds(roles);

        List<Menu> menus = menuDefinedMapper.queryMenusByIds(menuIds);

        /**
         * 封装power
         * 把menuIds赋给power
         * 循环power show（）menus
         *
         */

       /* for(Menu meun:menus){
            getFRes(meun,menus);//寻找资源的父节点(菜单头)
        }
        */
       log.info("===菜单列表==="+menus.toString());
        return menus;
    }
/*
    private void getFRes(Menu meun, List resources){
        if(meun.getParentId()!=null||!meun.getParentId().equals("1")){
            Menu father=menuMapper.selectByPrimaryKey(meun.getParentId());
            if(father!=null&&!father.getName().equals("root")){
                if(!resources.contains(father)){
                    resources.add(father);
                }
                getFRes(father,resources);
            }else{
                return;
            }

        }else{
            return;
        }
    }*/

}
