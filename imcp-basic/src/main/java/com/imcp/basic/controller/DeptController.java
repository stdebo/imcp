package com.imcp.basic.controller;

import com.imcp.basic.bean.Dept;
import com.imcp.basic.bean.Org;
import com.imcp.basic.service.DeptService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    private DeptService deptService;

    @ApiOperation(value = "新增部门")
    @ApiImplicitParam(name = "dept", value = "Dept", paramType = "query", required = true, dataType = "String")
    @RequestMapping("/addDept")
    public int addOrg(Dept dept){
        return deptService.addDept(dept);
    }

    @ApiOperation(value = "修改部门")
    @ApiImplicitParam(name = "dept", value = "Dept", paramType = "query", required = true, dataType = "String")
    @RequestMapping("/updateDept")
    public int updateOrg(Dept dept){
        return deptService.updateDept(dept);
    }

    @ApiOperation(value = "删除部门")
    @ApiImplicitParam(name = "id", value = "部门id", paramType = "query", required = true, dataType = "String")
    @RequestMapping("/delDept")
    public int delOrg(String id){
        return deptService.delDept(id);
    }

    @ApiOperation(value = "查询所有部门")
    @RequestMapping("/getAllDept")
    public List<Dept> getAllDept(){
        return deptService.getAllDept();
    }

    @ApiOperation(value = "查询下级部门列表")
    @ApiImplicitParam(name = "parent", value = "父级id", paramType = "query", required = true, dataType = "String")
    @RequestMapping("/getChildDept")
    public List<Dept> getChildDept(String parent,String deptName){
        return deptService.getChildDept(parent,deptName);
    }
}
