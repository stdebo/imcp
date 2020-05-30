package com.imcp.consumer.controllor;

import com.imcp.api.bean.Dept;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class ConsumerController {

    public static final String DEPT_GET_URL = "http://IMCP-BASIC/user/getUser/";
    public static final String DEPT_LIST_URL = "http://IMCP-BASIC/dept/list/";
    public static final String DEPT_ADD_URL = "http://IMCP-BASIC/dept/add?dname=";

    @Resource
    private RestTemplate restTemplate;
    @Resource
    private HttpHeaders headers;
    @Resource
    private LoadBalancerClient loadBalancerClient;

    @RequestMapping(value = "/consumer/user/getUser")
    public Object getDept(long id) {
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("IMCP-BASIC");
        System.out.println(
                "【*** ServiceInstance ***】host = " + serviceInstance.getHost()
                        + "、port = " + serviceInstance.getPort()
                        + "、serviceId = " + serviceInstance.getServiceId());
        Dept dept = this.restTemplate
                .exchange(DEPT_GET_URL + id, HttpMethod.GET,
                        new HttpEntity<Object>(this.headers), Dept.class)
                .getBody();
        return dept;
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/consumer/dept/list")
    public Object listDept() {
        List<Dept> allDepts = this.restTemplate
                .exchange(DEPT_LIST_URL, HttpMethod.GET,
                        new HttpEntity<Object>(this.headers), List.class)
                .getBody();
        return allDepts;
    }

    @RequestMapping(value = "/consumer/dept/add")
    public Object addDept(Dept dept) throws Exception {
        Boolean flag = this.restTemplate.exchange(DEPT_ADD_URL, HttpMethod.POST,
                new HttpEntity<Object>(dept, this.headers), Boolean.class)
                .getBody();
        return flag;
    }
}
