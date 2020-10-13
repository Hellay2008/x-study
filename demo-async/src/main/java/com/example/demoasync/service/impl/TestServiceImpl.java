package com.example.demoasync.service.impl;

import com.example.demoasync.service.TestService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

@Service
public class TestServiceImpl implements TestService {
    @Async("asyncTaskExecutor")
    @Override
    public Future<String> asyncTask(String s) {
        long startTime = System.currentTimeMillis();
        try {
            //模拟耗时
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName() + "：Future<String> asyncTask(String s)，耗时：" + (endTime - startTime));
        return AsyncResult.forValue(s);
    }

    @Override
    @Async("asyncTaskExecutor")
    public Future<Map<String, String>> asyncTask(String s, Map<String, String> map) {
        long startTime = System.currentTimeMillis();
        try {
            //模拟耗时
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName() + "：Future<String> asyncTask(String s)，耗时：" + (endTime - startTime));
        map.put(s, "hello " + s);
        return AsyncResult.forValue(map);
    }

    @Override
    @Async("asyncTaskExecutor")
    public Future<Map<String, String>> asyncTask2(String s, Map<String, String> map) {
        long startTime = System.currentTimeMillis();
        try {
            //模拟耗时
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName() + "：Future<String> asyncTask(String s)，耗时：" + (endTime - startTime));
        map.put(s, "hello " + s);
        return AsyncResult.forValue(map);
    }

    @Async("asyncTaskExecutor")
    public CompletableFuture<Map<String, String>> asyncTask3(String s, Map<String, String> map){
        long startTime = System.currentTimeMillis();
        try {
            //模拟耗时
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName() + "：Future<String> asyncTask(String s)，耗时：" + (endTime - startTime));
        map.put(s, "hello " + s);
        return CompletableFuture.completedFuture(map);
    }

    @Async("asyncTaskExecutor")
    public CompletableFuture<String> asyncTask4(String s){
        long startTime = System.currentTimeMillis();
        try {
            //模拟耗时
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String result = "hello " + s;
        return CompletableFuture.completedFuture(result);
    }

}
