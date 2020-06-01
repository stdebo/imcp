package com.imcp.geteway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 路由器
 * @EnableEurekaClient注解注册Eureka服务
 * @EnableZuulProxy注解开启zuul功能
 */
@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class GetewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GetewayApplication.class, args);
    }

}
