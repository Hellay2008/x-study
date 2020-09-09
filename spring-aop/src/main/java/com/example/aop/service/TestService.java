package com.example.aop.service;

import com.example.aop.annotation.MyAsync;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public interface TestService {
    Future<String> asyncTask(String s);
    Future<Map<String, String>> asyncTask(String s, Map<String, String> map);
    Future<Map<String, String>> asyncTask2(String s, Map<String, String> map);
    CompletableFuture<Map<String, String>> asyncTask3(String s, Map<String, String> map);
    void sayHello(String name);
}
