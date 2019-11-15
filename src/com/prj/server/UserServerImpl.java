package com.prj.server;

import com.prj.entity.User;
import com.prj.mapper.UserMapper;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//@Service业务逻辑层
@Service("UserServerImpl")
public class UserServerImpl implements UserServer {
    //@Autowired自动装配
    @Autowired
    private UserMapper userMapper;

    public UserMapper getUserMapper() {
        return userMapper;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }


    //查询用户
    @Override
    public List<User> queryList(int page, int limit) {
        return userMapper.queryList(page,limit);
    }
    //用户总行数
    @Override
    public int count() {
        return userMapper.count();
    }
    @Override
    public int addUser(User user){
        return userMapper.addUser(user);
    }
    //删除用户
    @Override
    public int delUser(int id) {
        return userMapper.delUser(id);
    }
        //修改用户
        @Override
        public int updateUser( User user){
            return userMapper.updateUser(user);
        }
            @Override
            public User queryById(int id){
                return userMapper.queryById(id);
            }
        }


