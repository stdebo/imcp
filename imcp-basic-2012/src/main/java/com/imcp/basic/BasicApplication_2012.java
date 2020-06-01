package com.imcp.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;


@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.imcp.basic.mapper")
public class BasicApplication_2012 {

    private static final Logger logger = LoggerFactory.getLogger(BasicApplication_2012.class);

    public static void main(String[] args) {
        SpringApplication.run(BasicApplication_2012.class, args);
        logger.info("========================启动完毕========================");
    }

}
