package com.imcp.consumer.controllor;


import com.imcp.api.bean.basic.User;
import com.imcp.api.service.IUserClientService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ConsumerController {

    @Resource
    private IUserClientService userClientService ;

    @RequestMapping(value = "/consumer/getUser/{id}")
    public User getUser2(@PathVariable String id) {
        return this.userClientService.getUser2(id);
    }

}
