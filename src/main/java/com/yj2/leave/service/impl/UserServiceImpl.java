package com.yj2.leave.service.impl;

import com.yj2.leave.entity.User;
import com.yj2.leave.entity.UserExample;
import com.yj2.leave.exception.ExceptionEnum;
import com.yj2.leave.exception.ServiceException;
import com.yj2.leave.mapper.UserDefinedMapper;
import com.yj2.leave.mapper.UserMapper;
import com.yj2.leave.service.UserService;
import com.yj2.leave.util.EncryDigestUtil;
import com.yj2.leave.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service("com.yj2.leave.service.impl.UserServiceImpl")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserDefinedMapper userDefinedMapper;

    /**
     * 用户登录
     * @param account
     * @param password
     * @return
     */
    @Override
    @Transactional
    public User userLogin(String account, String password) {

        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andAccountEqualTo(account);

        List<User> list = userMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            throw new ServiceException(ExceptionEnum.NOT_EXIST);
        }
        User managerInfo = list.get(0);
        int status = managerInfo.getStatus();
        if(status==2||status==3){
            String ps = managerInfo.getPassword();
            if (!ps.equals(EncryDigestUtil.digest(password))) {
                throw new ServiceException(ExceptionEnum.ERROR＿PASSWORD);
            }
            //生成token
            String token;
            try {
                token = TokenUtil.createJwt(managerInfo.getId());
            } catch (ServiceException e) {
                throw new ServiceException(ExceptionEnum.ERROE_CREATE_TOKEN);
            }
            //保存token
            managerInfo.setSalt(token);

            UserExample example1 = new UserExample();
            UserExample.Criteria criteria1 = example1.createCriteria();
            criteria1.andIdEqualTo(managerInfo.getId());
            userMapper.updateByExampleSelective(managerInfo, example1);

            managerInfo.setSalt(token);
            return managerInfo;
        }else{
            throw new ServiceException(ExceptionEnum.NOT_EXIST);
        }
    }

    @Override
    public void register(String systemId, String account, String name, String role) {
        User user1 = userDefinedMapper.getUserByAccount(account);
        if(user1!=null){
            throw new ServiceException(ExceptionEnum.ACCOUNT_EXIST);
        }

        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setAccount(account);
        user.setName(name);
        user.setStatus(0);
        user.setPassword(EncryDigestUtil.digest("123123"));
        user.setCreatedBy(systemId);


        userMapper.insert(user);
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

}
