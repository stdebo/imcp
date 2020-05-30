package com.imcp.basic.service;

import com.imcp.basic.bean.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleService {
    //新增角色
    public int addRole(Role role);
    //修改角色
    public int updateRole(Role role);
    //删除角色
    public int delRole(String id);
    //获取角色列表
    public List<Role> getAllRole();
}
