package com.imcp.consumer.controllor;

import com.imcp.api.bean.basic.Dept;
import com.imcp.api.bean.basic.User;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class ConsumerController {

    public static final String USER_GET_URL = "http://127.0.0.1:2010/user/getUser/";

    @Resource
    private RestTemplate restTemplate;
    @Resource
    private HttpHeaders headers;

    @RequestMapping(value = "/consumer/user/getUser/{id}")
    public Object getDept(@PathVariable String id) {
        User user = this.restTemplate
                .exchange(USER_GET_URL + id, HttpMethod.GET,
                        new HttpEntity<Object>(this.headers), User.class)
                .getBody();
        return user;
    }
}
