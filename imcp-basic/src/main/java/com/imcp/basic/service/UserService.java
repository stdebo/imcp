package com.imcp.basic.service;

import com.imcp.basic.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {
    //查找所有的用户
    List<User> getAllUser();

    //添加用户
    void addUser(User user);

    //根据用户名、密码查找用户
    User getUser(@Param("username") String username, @Param("password") String password);

    void delete(String guid);

    User getUserByGuid(String guid);

    void edit(User user);
}
