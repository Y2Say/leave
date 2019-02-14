package com.yj2.leave.mapper;

import com.yj2.leave.entity.Role;

import java.util.List;

public interface UserRoleDefinedMapper {

    /**
     * 根据用户ID获取角色Ids
     * @param userId
     * @return
     */
    List<String> queryRoleIdsByUserId(String userId);

}