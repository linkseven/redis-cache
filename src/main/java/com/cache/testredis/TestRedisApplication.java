package com.cache.testredis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@MapperScan("com.cache.testredis.mapper")
@EnableCaching
@SpringBootApplication
public class TestRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestRedisApplication.class, args);
    }

}
