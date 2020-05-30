package com.imcp.basic.service;

import com.imcp.basic.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {
    //查找所有的用户
    List<User> getAllUser();

    //添加用户
    int addUser(User user);

    //根据用户名、密码查找用户
    User getUser(@Param("userName") String userName, @Param("passWord") String passWord);

    //删除用户
    int delete(String guid);

    //根据guid查询用户
    User getUserByGuid(String guid);

    //修改用户
    int edit(User user);
}
