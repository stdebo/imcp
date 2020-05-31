package com.imcp.basic.controller;

import com.imcp.basic.bean.User;
import com.imcp.basic.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Api(description = "用户操作接口")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

//    @ApiOperation(value = "获取用户", notes="通过GUID获取用户信息")
//    @ApiImplicitParam(name = "guid", value = "用户GUID", paramType = "query", required = true, dataType = "String")
//    @RequestMapping("/getUser")
//    public User getUser(@RequestParam("id") String id) {
//        System.out.println(userService.getUserByGuid(id));
//        return userService.getUserByGuid(id);
//
//    }
//
//    @ApiOperation(value = "获取用户", notes="通过GUID获取用户信息")
//    @ApiImplicitParam(name = "guid", value = "用户GUID", paramType = "query", required = true, dataType = "String")
//    @RequestMapping("/getUser/{id}")
//    public User getUser2(@PathVariable String id) {
//        return userService.getUserByGuid(id);
//    }

    @ApiOperation(value = "删除用户", notes="通过ID删除用户信息")
    @ApiImplicitParam(name = "id", value = "用户ID", paramType = "query", required = true, dataType = "String")
    @RequestMapping("/delUser")
    public void delUser(String id){
        userService.delete(id);
    }

    @ApiOperation(value = "获取用户", notes="通过用户code和密码获取用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userCode", value = "用户userCode", paramType = "query", required = true, dataType = "String"),
            @ApiImplicitParam(name = "passWord", value = "用户密码", paramType = "query", required = true, dataType = "String")
    })
    @RequestMapping("/queryUser")
    public User queryUser(String userCode,String passWord){
       return userService.getUser(userCode,passWord);
    }

    @ApiOperation(value = "新增用户")
    @ApiImplicitParam(name = "user", value = "User", paramType = "query", required = true, dataType = "User")
    @RequestMapping("/addUser")
    public int addUser(User user){
        return userService.addUser(user);
    }

    @ApiOperation(value = "修改用户")
    @ApiImplicitParam(name = "user", value = "User", paramType = "query", required = true, dataType = "User")
    @RequestMapping("/updateUser")
    public void updateUser(User user){
        userService.edit(user);
    }
}