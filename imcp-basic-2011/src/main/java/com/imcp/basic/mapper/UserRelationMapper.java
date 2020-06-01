package com.imcp.basic.mapper;

import com.imcp.basic.bean.Dept;
import com.imcp.basic.bean.User;
import com.imcp.basic.bean.UserRelation;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;


public interface UserRelationMapper extends Mapper<UserRelation> {
    /**
     * 查询用户列表
     * @param userRelation
     * @return
     */
    public List<User> getRoleUser(UserRelation userRelation);

    /**
     * deptGuid查询部门
     * @param orgGuid
     * @return
     */
    public List<Dept> getOrgDept(String orgGuid);
}
