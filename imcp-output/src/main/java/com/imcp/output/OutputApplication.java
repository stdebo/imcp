package com.imcp.output;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class OutputApplication {

    public static void main(String[] args) {
        SpringApplication.run(OutputApplication.class, args);
    }

}
