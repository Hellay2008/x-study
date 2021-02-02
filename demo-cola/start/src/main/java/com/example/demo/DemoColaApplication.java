package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.example.demo", "com.alibaba.cola" })
@MapperScan("com.example.demo.gatewayimpl.database")
public class DemoColaApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoColaApplication.class, args);
    }

}
