package com.example.demo;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableMethodCache(basePackages="com.example.demo")
@EnableCreateCacheAnnotation
public class DemoJetcacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoJetcacheApplication.class, args);
    }

}
