package com.prj.mapper;

import com.prj.entity.Role;
import com.prj.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {

    //查询角色
    public List<Role> queryRoleList();
}
