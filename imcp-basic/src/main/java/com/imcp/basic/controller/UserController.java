package com.imcp.basic.controller;

import com.imcp.basic.bean.User;
import com.imcp.basic.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
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

    @ApiOperation(value = "获取用户", notes="通过GUID获取用户信息")
    @ApiImplicitParam(name = "guid", value = "用户GUID", paramType = "query", required = true, dataType = "String")
    @RequestMapping("/getUser")
    public User getUser(@RequestParam("guid") String guid) {
        return userService.getUserByGuid(guid);
    }

    @ApiOperation(value = "获取用户", notes="通过GUID获取用户信息")
    @ApiImplicitParam(name = "guid", value = "用户GUID", paramType = "query", required = true, dataType = "String")
    @RequestMapping("/getUser/{guid}")
    public User getUser2(@PathVariable String guid) {
        return userService.getUserByGuid(guid);
    }

    /**
     * 删除用户
     * @param guid
     */
    @RequestMapping("/delUser")
    public void delUser(String guid){
        userService.delete(guid);
    }

    /**
     * 用户密码
     * @param userName
     * @param passWord
     * @return
     */
    @RequestMapping("/queryUser")
    public User queryUser(String userName,String passWord){
       return userService.getUser(userName,passWord);
    }

    /**
     * 新增用户
     * @param user
     * @return
     */
    @RequestMapping("/addUser")
    public int addUser(User user){
        return userService.addUser(user);
    }

    /**
     * 修改用户
     * @param user
     */
    @RequestMapping("/updateUser")
    public void updateUser(User user){
        userService.edit(user);
    }
}