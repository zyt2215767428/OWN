package com.prj.controller;

import com.prj.entity.Role;
import com.prj.server.RoleServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class RoleController {

    @Autowired
    @Qualifier("RoleServerImpl")
    private RoleServer roleServer;



    //查询角色信息
    @ResponseBody
    @RequestMapping("/queryRole")
    public List<Role> queryRole(){
        return roleServer.queryRoleList();
    }




    public RoleServer getRoleServer() {
        return roleServer;
    }

    public void setRoleServer(RoleServer roleServer) {
        this.roleServer = roleServer;
    }
}
