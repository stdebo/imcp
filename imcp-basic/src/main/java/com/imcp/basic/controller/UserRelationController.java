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

import java.util.List;
@Api(description = "用户关联接口")
@RestController
@RequestMapping("/relation")
public class UserRelationController {
    @Autowired
    private UserRelationService userRelationService;

    /**
     * 查询所有关联关系
     * @return
     */
    @RequestMapping("/getAllUserRelation")
    public List<UserRelation> getAllUserRelation(){
        return userRelationService.getAllUserRelation();
    }

    /**
     * 查询用户列表
     * @param userRelation
     * @return
     */
    @RequestMapping("/getRoleUser")
    public List<User> getRoleUser(UserRelation userRelation){
        return userRelationService.getRoleUser(userRelation);
    }

    /**
     *查询组织下面的部门
     * @param orgGuid
     * @return
     */
    @RequestMapping("/getOrgDept")
    public List<Dept> getOrgDept(String orgGuid){
        return userRelationService.getDeptUser(orgGuid);
    }
}
