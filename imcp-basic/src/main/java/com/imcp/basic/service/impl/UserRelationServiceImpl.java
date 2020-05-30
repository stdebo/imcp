package com.imcp.basic.service.impl;

import com.imcp.basic.bean.Dept;
import com.imcp.basic.bean.User;
import com.imcp.basic.bean.UserRelation;
import com.imcp.basic.mapper.UserRelationMapper;
import com.imcp.basic.service.UserRelationService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
@Component
public class UserRelationServiceImpl implements UserRelationService {
    @Resource
    private UserRelationMapper userRelationMapper;

    @Override
    public int addUserRelation(UserRelation userRelation) {
        return userRelationMapper.insert(userRelation);
    }

    @Override
    public int updateUserRelation(UserRelation userRelation) {
        return userRelationMapper.updateByPrimaryKey(userRelation);
    }

    @Override
    public int delUserRelation(String id) {
        return userRelationMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<UserRelation> getAllUserRelation() {
        return userRelationMapper.selectAll();
    }

    @Override
    public List<User> getRoleUser(UserRelation userRelation) {
        return userRelationMapper.getRoleUser(userRelation);
    }

    @Override
    public List<Dept> getDeptUser(String orgGuid) {
        return userRelationMapper.getOrgDept(orgGuid);
    }
}
