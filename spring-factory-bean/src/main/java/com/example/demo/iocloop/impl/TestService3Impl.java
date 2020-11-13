package com.example.demo.iocloop.impl;

import com.example.demo.iocloop.TestService2;
import com.example.demo.iocloop.TestService3;
import com.example.demo.iocself.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@Lazy(value = false)
public class TestService3Impl implements TestService3 {
    @Autowired
    TestService3 testService3;

    @Autowired
    TestService2 testService2;

    @Override
    public void test31() {
        System.out.println("TestService3Impl->public void test31()");
    }

    @Override
    public void test32() {
        System.out.println("TestService3Impl->public void test32()");
        testService3.test31();
    }
}
