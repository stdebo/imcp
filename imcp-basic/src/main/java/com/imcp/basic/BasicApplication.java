package com.imcp.basic;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.imcp.basic.mapper")
public class BasicApplication {

    private static final Logger logger = LoggerFactory.getLogger(BasicApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(BasicApplication.class, args);
        logger.info("========================启动完毕========================");
    }

}
