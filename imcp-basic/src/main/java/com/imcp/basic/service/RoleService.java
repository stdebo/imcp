package com.imcp.basic.service;

import com.imcp.basic.bean.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleService {
    //查找所有的角色
    List<Role> getAllRole();
    //添加角色
    int addRole(Role role);
    //删除角色
    int delete(String guid);
    //查询角色
    Role getRolerByGuid(String guid);
    //修改角色
    int updateRole(Role role);
}
