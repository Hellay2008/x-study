package com.example.aop;

import com.example.aop.service.TestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@SpringBootTest
class SpringAopApplicationTests {

    @Autowired
    TestService testService;

    @Test
    void contextLoads() {
    }

    @Test
    public void testAop(){
        testService.sayHello("gongye");
    }

    @Test
    public void testFuture() throws ExecutionException, InterruptedException {
        long startTime = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName() + "：开始调用异步业务");
        //无返回值
        Map<String, String> map = new HashMap<>();
        Future<Map<String, String>> future = testService.asyncTask2("hhh", map);
        long endTime = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName() + "：调用异步业务结束，耗时：" + (endTime - startTime) + "ms");
        System.out.println("future.get=" + future.get());
    }

    @Test
    public void testMyAsyncFuture() throws ExecutionException, InterruptedException {
        long startTime = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName() + "：开始调用异步业务");
        //无返回值
        Map<String, String> map = new HashMap<>();
        Future<Map<String, String>> future = testService.asyncTask2("hhh", map);
        long endTime = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName() + "：调用异步业务结束，耗时：" + (endTime - startTime) + "ms");
        System.out.println("future.get=" + future.get());
    }


}
