package com.imcp.basic.service.impl;

import com.imcp.basic.bean.User;
import com.imcp.basic.mapper.UserMapper;
import com.imcp.basic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> getAllUser() {
        return userMapper.selectAll();
    }

    @Override
    public int addUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public User getUser(String userName, String passWord) {
        return userMapper.queryUser(userName,passWord);
    }

    @Override
    public int delete(String id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public User getUserByGuid(String guid) {
        return userMapper.selectByPrimaryKey(guid);
    }

    @Override
    public int edit(User user) {
        return userMapper.updateByPrimaryKey(user);
    }
}
