package org.example;

import org.example.event.CustomEvent;
import org.example.config.CustomEventConfig;
import org.example.service.MyPublisher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
public class Client {
    @Autowired
    MyPublisher myPublisher;
    @Test
    public void test(){
//        ApplicationContext context = new AnnotationConfigApplicationContext(CustomEventConfig.class);
//        MyPublisher myPublisher = (MyPublisher) context.getBean("myPublisher");
        myPublisher.publishEvent(new CustomEvent(this));
    }
}
