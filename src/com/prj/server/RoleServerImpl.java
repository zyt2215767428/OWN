package com.prj.server;

import com.prj.entity.Role;
import com.prj.entity.User;
import com.prj.mapper.RoleMapper;
import com.prj.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service业务逻辑层
@Service("RoleServerImpl")
public class RoleServerImpl implements RoleServer {
    //@Autowired自动装配
    @Autowired
    private RoleMapper roleMapper;

    public RoleMapper getRoleMapper() {
        return roleMapper;
    }

    public void setRoleMapper(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }

    @Override
    public List<Role> queryRoleList() {
        return roleMapper.queryRoleList();
    }
}
