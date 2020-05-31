package com.imcp.consumer.controllor;

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

@RestController
public class ConsumerController {

    public static final String USER_GET_URL = "http://IMCP-BASIC/user/getUser/";

    @Resource
    private RestTemplate restTemplate;
    @Resource
    private HttpHeaders headers;

    @Resource
    private LoadBalancerClient loadBalancerClient ;

    @RequestMapping(value = "/consumer/user/getUser/{id}")
    public Object getDept(@PathVariable String id) {

        ServiceInstance serviceInstance = this.loadBalancerClient.choose("IMCP-BASIC") ;

        System.out.println(
                "【*** ServiceInstance ***】host = " + serviceInstance.getHost()
                        + "、port = " + serviceInstance.getPort()
                        + "、serviceId = " + serviceInstance.getServiceId());

        User user = this.restTemplate
                .exchange(USER_GET_URL + id, HttpMethod.GET,
                        new HttpEntity<Object>(this.headers), User.class)
                .getBody();
        return user;
    }
}
