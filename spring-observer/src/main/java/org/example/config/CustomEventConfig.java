package org.example.config;

import org.example.service.MyPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomEventConfig {
    @Bean(name = "myPublisher")
    public MyPublisher myPublisher(){
        return new MyPublisher();
    }
}
