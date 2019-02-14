package com.yj2.leave.mapper;

import com.yj2.leave.entity.Role;

import java.util.List;

public interface PermissionDefinedMapper {

    List<String> queryMenuIdsByRoleIds(List roleIds);
}
