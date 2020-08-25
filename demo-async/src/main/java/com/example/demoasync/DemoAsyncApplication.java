package com.example.demoasync;

import com.example.demoasync.service.TestService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;

@SpringBootApplication
public class DemoAsyncApplication {

    @Resource
    TestService testService;

    public static void main(String[] args) {
        SpringApplication.run(DemoAsyncApplication.class, args);
    }

    /**
     * 启动成功
     */
    @Bean
    public ApplicationRunner applicationRunner() {
        return applicationArguments -> {
//            long startTime = System.currentTimeMillis();
//            System.out.println(Thread.currentThread().getName() + "：开始调用异步业务");
//            //无返回值
//            Future<String> future = testService.asyncTask("hhh");
//            long endTime = System.currentTimeMillis();
//            System.out.println(Thread.currentThread().getName() + "：调用异步业务结束，耗时：" + (endTime - startTime));
//            System.out.println("future.get=" + future.get());


//            long startTime = System.currentTimeMillis();
//            System.out.println(Thread.currentThread().getName() + "：开始调用异步业务");
//            //无返回值
//            Map<String, String> map = new HashMap<>();
//            Future<Map<String, String>> future = testService.asyncTask("hhh", map);
//            long endTime = System.currentTimeMillis();
//            System.out.println(Thread.currentThread().getName() + "：调用异步业务结束，耗时：" + (endTime - startTime));
//            System.out.println("future.get=" + future.get().get("hhh"));

            long startTime = System.currentTimeMillis();
            System.out.println(Thread.currentThread().getName() + "：开始调用异步业务");
            //无返回值
            Map<String, String> map = new HashMap<>();
            Future<Map<String, String>> future = testService.asyncTask2("hhh", map);
            long endTime = System.currentTimeMillis();
            System.out.println(Thread.currentThread().getName() + "：调用异步业务结束，耗时：" + (endTime - startTime));
            System.out.println("future.get=" + future.get().get("hhh"));

        };
    }

}
