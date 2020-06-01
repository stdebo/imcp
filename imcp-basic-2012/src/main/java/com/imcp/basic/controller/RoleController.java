package com.imcp.basic.controller;

import com.imcp.basic.bean.Role;
import com.imcp.basic.service.RoleService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @ApiOperation(value = "新增角色")
    @ApiImplicitParam(name = "role", value = "Role", paramType = "query", required = true, dataType = "String")
    @RequestMapping("/addRole")
    public int addRole(Role role){
        return roleService.addRole(role);
    }

    @ApiOperation(value = "修改角色")
    @ApiImplicitParam(name = "role", value = "Role", paramType = "query", required = true, dataType = "String")
    @RequestMapping("/updateRole")
    public int updateRole(Role role){
        return roleService.updateRole(role);
    }

    @ApiOperation(value = "删除角色")
    @ApiImplicitParam(name = "id", value = "角色id", paramType = "query", required = true, dataType = "String")
    @RequestMapping("/delRole")
    public int delRole(String id){
        return roleService.delRole(id);
    }

    @ApiOperation(value = "查询所有角色")
    @RequestMapping("/getAllRole")
    public List<Role> getAllRole(){
        return roleService.getAllRole();
    }
}
