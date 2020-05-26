package com.imcp.objects;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ObjectsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ObjectsApplication.class, args);
    }

}
