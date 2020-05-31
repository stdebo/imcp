package com.imcp.basic.controller;

import com.imcp.basic.bean.Dept;
import com.imcp.basic.bean.User;
import com.imcp.basic.bean.UserRelation;
import com.imcp.basic.service.UserRelationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.management.relation.Relation;
import java.util.List;
@Api(description = "用户关联接口")
@RestController
@RequestMapping("/relation")
public class UserRelationController {
    @Autowired
    private UserRelationService userRelationService;

    @ApiOperation(value = "查询所有关联关系")
    @ApiImplicitParam( dataType = "List")
    @RequestMapping("/getAllUserRelation")
    public List<UserRelation> getAllUserRelation(){
        return userRelationService.getAllUserRelation();
    }

    @ApiOperation(value = "查询关联用户、管理部门", notes="通过UserRelation信息")
    @ApiImplicitParam(name = "userRelation", value = "UserRelation", paramType = "query", required = true, dataType = "UserRelation")
    @RequestMapping("/getRoleUser")
    public List<User> getRoleUser(UserRelation userRelation){
        return userRelationService.getRoleUser(userRelation);
    }

    @ApiOperation(value = "查询组织下的部门信息", notes="通过orgGuid获取组织下部门信息")
    @ApiImplicitParam(name = "orgGuid", value = "组织id", paramType = "query", required = true, dataType = "String")
    @RequestMapping("/getOrgDept")
    public List<Dept> getOrgDept(String orgGuid){
        return userRelationService.getDeptUser(orgGuid);
    }

    @ApiOperation(value = "新增关联关系")
    @ApiImplicitParam(name = "userRelation", value = "UserRelation", paramType = "query", required = true, dataType = "String")
    @RequestMapping("/addRelation")
    public int addRelation(UserRelation userRelation){
        return userRelationService.addUserRelation(userRelation);
    }

    @ApiOperation(value = "删除关联关系")
    @ApiImplicitParam(name = "id", value = "关联id", paramType = "query", required = true, dataType = "String")
    @RequestMapping("/delRelation")
    public int delRelation(String id){
        return userRelationService.delUserRelation(id);
    }
}
