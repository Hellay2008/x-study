package com.example.demo.iocself.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Autowired
    TestService testService;

    public void test1(){
        System.out.println("public void test1()");
    }

    public void test2(){
        System.out.println("public void test2()");
        testService.test1();
    }
}
