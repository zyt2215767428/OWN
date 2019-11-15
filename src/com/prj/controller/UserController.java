package com.prj.controller;

import com.prj.entity.User;
import com.prj.entity.UserVO;
import com.prj.server.UserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    @Qualifier("UserServerImpl")
    private UserServer userServer;


    //查询用户
    //page：当前页数,limit：每一页行数
    @ResponseBody
    @RequestMapping("/queryUser")
    public Map<String,Object> queryUser(int page,int limit){
        Map<String,Object> jsonMap=new HashMap<String,Object>();
        //(当前页数-1)*每页行数
        page=(page-1)*limit;

        List<User> userList=userServer.queryList(page,limit);

        List<UserVO> jsonUserList=new ArrayList<UserVO>();

        for(User user:userList){
            UserVO userVO=new UserVO();
            userVO.setId(user.getId());
            userVO.setUname(user.getUname());
            userVO.setRname(user.getRole().getRname());

            jsonUserList.add(userVO);
        }

        jsonMap.put("code",0);
        jsonMap.put("msg","");
        jsonMap.put("count",userServer.count());//总行数
        jsonMap.put("data",userList);//数据

        return jsonMap;
    }

    //添加用户
    @ResponseBody
    @RequestMapping("/addUser")
    public String addUser(User user){
        userServer.addUser(user);
        return "添加成功";
    }
    //删除用户
    @ResponseBody
    @RequestMapping("/delUser/{id}")
    public String delUser(@PathVariable int id){
        userServer.delUser(id);
        return "删除成功";
    }
    //修改用户
    @ResponseBody
    @RequestMapping("/updateUser")
    public String updateUser(User user){
        userServer.updateUser(user);
        return "修改成功";
    }
    //按照ID进行查询
    @RequestMapping("/queryById/{id}")
    public String queryById(@PathVariable int id, HttpServletRequest request){
        request.setAttribute("user",userServer.queryById(id));
        return "/update.jsp";
    }



    public UserServer getUserServer() {
        return userServer;
    }

    public void setUserServer(UserServer userServer) {
        this.userServer = userServer;
    }
}









