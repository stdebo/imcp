package com.imcp.basic.controller;

import com.imcp.basic.bean.Role;
import com.imcp.basic.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    /**
     * 新增角色
     * @param role
     * @return
     */
    @RequestMapping("/addRole")
    public int addRole(Role role){
        return roleService.addRole(role);
    }

    /**
     * 修改角色
     * @param role
     * @return
     */
    @RequestMapping("/updateRole")
    public int updateRole(Role role){
        return roleService.updateRole(role);
    }

    /**
     * 删除角色
     * @param id
     * @return
     */
    @RequestMapping("/delRole")
    public int delRole(String id){
        return roleService.delRole(id);
    }

    /**
     * 查询所有角色
     * @return
     */
    @RequestMapping("/getAllRole")
    public List<Role> getAllRole(){
        return roleService.getAllRole();
    }
}
