package com.imcp.basic.service.impl;

import com.imcp.basic.bean.Role;
import com.imcp.basic.mapper.RoleMapper;
import com.imcp.basic.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
@Component
public class RoleServiceIpml implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public int addRole(Role role) {
        return roleMapper.insert(role);
    }

    @Override
    public int updateRole(Role role) {
        return roleMapper.updateByPrimaryKey(role);
    }

    @Override
    public int delRole(String id) {
        return roleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Role> getAllRole() {
        return roleMapper.selectAll();
    }
}
