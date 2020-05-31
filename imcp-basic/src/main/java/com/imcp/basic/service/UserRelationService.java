package com.imcp.basic.service;


import com.imcp.basic.bean.Dept;
import com.imcp.basic.bean.User;
import com.imcp.basic.bean.UserRelation;

import java.util.List;

public interface UserRelationService {
    //新增关联关系
    public int addUserRelation(UserRelation userRelation);
    //删除关联关系
    public int delUserRelation(String id);
    //查询列表
    public List<UserRelation> getAllUserRelation();
    //根据角色id查询用户
    public List<User> getRoleUser(UserRelation userRelation);
    //查询组织下的部门
    public List<Dept> getDeptUser(String orgGuid);
}
