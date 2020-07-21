package org.example;

import org.example.service.MyPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringObserverApplication {

    @Autowired
    MyPublisher myPublisher;

    public static void main(String[] args) {
        SpringApplication.run(SpringObserverApplication.class, args);
    }
}
