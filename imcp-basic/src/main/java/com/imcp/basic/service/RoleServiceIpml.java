package com.imcp.basic.service;

import com.imcp.basic.bean.Role;
import com.imcp.basic.mapper.RoleMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
@Component
public class RoleServiceIpml implements RoleService {
    @Resource
    private RoleMapper roleMapper;
    @Override
    public List<Role> getAllRole() {
        return roleMapper.getAllRole();
    }

    @Override
    public int addRole(Role role) {
        return roleMapper.addRole(role);
    }

    @Override
    public int delete(String guid) {
        return roleMapper.delRole(guid);
    }

    @Override
    public Role getRolerByGuid(String guid) {
        return roleMapper.queryRole(guid);
    }

    @Override
    public int updateRole(Role role) {
        return roleMapper.updateRole(role);
    }
}
