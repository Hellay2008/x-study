package com.example.demo.config;

import com.example.demo.service.TestService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {
    @Bean
    public TestService getTestService(){
        TestService testService = new TestService();
        testService.source = "bean";
        return testService;
    }
}
