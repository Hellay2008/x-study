package com.example.demo;

import com.example.demo.service.TestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@SpringBootTest
class SpringBootDemoApplicationTests {

    @Resource(name="getTestService")
    TestService testService1;

    @Resource(type = TestService.class)
    TestService testService2;

    @Test
    void contextLoads() {
    }

    @Test
    public void testOverride(){
        System.out.println(testService1.sayHello());
        System.out.println(testService2.sayHello());
    }

}
