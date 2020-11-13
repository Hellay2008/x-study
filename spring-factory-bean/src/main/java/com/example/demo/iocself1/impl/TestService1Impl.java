package com.example.demo.iocself1.impl;

import com.example.demo.iocself1.TestService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class TestService1Impl implements TestService1 {

    @Autowired
    TestService1 testService1;

    @Override
    public void test1() {
        System.out.println("TestService1Impl->public void test1()");
    }

    @Override
    public void test2() {
        System.out.println("TestService1Impl->public void test2()");
        testService1.test1();
    }
}
