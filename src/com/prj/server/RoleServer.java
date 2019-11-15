package com.prj.server;

import com.prj.entity.Role;
import com.prj.entity.User;

import java.util.List;

public interface RoleServer {
    //查询角色
    public List<Role> queryRoleList();
}
