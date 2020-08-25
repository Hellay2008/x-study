package com.example.demoasync.service;

import java.util.Map;
import java.util.concurrent.Future;

public interface TestService {
    Future<String> asyncTask(String s);
    Future<Map<String, String>> asyncTask(String s, Map<String, String> map);
    Future<Map<String, String>> asyncTask2(String s, Map<String, String> map);
}
