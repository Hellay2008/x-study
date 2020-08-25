package com.example.demojetcachelocal;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableMethodCache(basePackages="com.example.demojetcachelocal")
@EnableCreateCacheAnnotation
public class DemoJetcacheLocalApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoJetcacheLocalApplication.class, args);
    }

}
