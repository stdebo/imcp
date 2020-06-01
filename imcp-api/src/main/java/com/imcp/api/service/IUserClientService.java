package com.imcp.api.service;

import java.util.List;

import com.imcp.api.bean.basic.Dept;
import com.imcp.api.bean.basic.User;
import com.imcp.api.config.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(value="IMCP-BASIC",configuration=FeignClientConfig.class)
public interface IUserClientService {

    @RequestMapping(method=RequestMethod.GET,value="/user/getUser/{id}")
    User getUser2(@PathVariable("id") String id) ;


}
