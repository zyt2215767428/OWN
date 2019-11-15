package com.prj.mapper;

import com.prj.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    //查询用户
    public List<User> queryList(@Param("page") int page, @Param("limit") int limit);

    //查询用户总行数
    public int count();
    //添加用户
    public int addUser(User user);
    //删除用户
    public int delUser(int id);
    //修改用户
    public int updateUser(User user);
    //按照ID查询用户
    public User queryById(int id);
}
