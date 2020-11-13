package com.example.demo.controller;

import com.example.demo.TestBean;
import com.example.demo.iocloop.TestService2;
import com.example.demo.iocself.service.TestService;
import com.example.demo.iocself1.TestService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    TestBean testBean;
    @Autowired
    TestService testService;

    @Autowired
    TestService1 testService1;

    @Autowired
    TestService2 testService2;

    @GetMapping("/test")
    public String test(){
        return testBean.getResult("will");
    }

    @GetMapping("/test1")
    public String test1(){
        testService.test1();
        return "test2";
    }

    @GetMapping("/test2")
    public String test2(){
        testService1.test2();
        return "test2";
    }


    @GetMapping("/test22")
    public String test22(){
        testService2.test22();
        return "test22";
    }

}
