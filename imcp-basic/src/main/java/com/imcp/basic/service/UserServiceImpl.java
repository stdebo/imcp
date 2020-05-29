package com.imcp.basic.service;

import com.imcp.basic.bean.User;
import com.imcp.basic.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public User getUser(String userName, String passWord) {
        return userMapper.queryUser(userName,passWord);
    }

    @Override
    public int delete(String guid) {
        return userMapper.delUser(guid);
    }

    @Override
    public User getUserByGuid(String guid) {
        return userMapper.getUserByGuid(guid);
    }

    @Override
    public int edit(User user) {
        return userMapper.updateUser(user);
    }
}
