package com.example.demo.iocloop.impl;

import com.example.demo.iocloop.TestService2;
import com.example.demo.iocloop.TestService3;
import com.example.demo.iocself.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@Lazy(value = false)
public class TestService2Impl implements TestService2 {
    @Autowired
    TestService2 testService2;

    @Autowired
    TestService3 testService3;

    @Override
    public void test21() {
        System.out.println("TestService2Impl->public void test21()");
    }

    @Override
    public void test22() {
        System.out.println("TestService2Impl->public void test22()");
        testService2.test21();
    }
}
