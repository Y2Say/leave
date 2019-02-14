package com.yj2.leave.mapper;

import com.yj2.leave.entity.Menu;
import com.yj2.leave.entity.MenuExample;

import java.util.List;

public interface MenuDefinedMapper {

    List<Menu> queryMenusByIds(List menuIds);

}