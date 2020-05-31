package com.imcp.consumer;

import com.imcp.consumer.config.LoadBalanceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@EnableDiscoveryClient
@SpringBootApplication
@RibbonClient(name = "ribbonClient", configuration = LoadBalanceConfig.class)
public class ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

}
