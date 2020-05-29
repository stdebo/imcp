package com.imcp.basic.mapper;

import com.imcp.basic.bean.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleMapper {
    //新增角色
    public int addRole(Role role);
    //删除角色
    public int delRole(String guid);
    //修改角色
    public int updateRole(Role role);
    //查询角色
    public Role queryRole(String guid);
    //查询角色列表
    public List<Role> getAllRole();
}
