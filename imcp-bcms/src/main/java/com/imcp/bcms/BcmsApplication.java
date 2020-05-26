package com.imcp.bcms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class BcmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(BcmsApplication.class, args);
    }

}
