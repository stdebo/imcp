package com.imcp.objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.imcp.objects.mapper")
public class ObjectsApplication {
    private static final Logger logger = LoggerFactory.getLogger(ObjectsApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ObjectsApplication.class, args);
        logger.info("===================启动成功==================");
    }
}