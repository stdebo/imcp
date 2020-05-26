package com.imcp.basic.controller;

import com.imcp.basic.bean.User;
import com.imcp.basic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/user")
    public User getUser(@RequestParam("guid") String guid) {
        return userService.getUserByGuid(guid);
    }

    @RequestMapping("/user/{guid}")
    public User getUser2(@PathVariable String guid) {
        return userService.getUserByGuid(guid);
    }
}