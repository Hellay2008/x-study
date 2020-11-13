package com.example.demoasync;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.task.AsyncTaskExecutor;

import java.sql.SQLOutput;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class DemoAsyncApplicationTests {
    @Test
    void contextLoads() {
    }

    @Test
    public void thenApply() {
        String result = CompletableFuture.supplyAsync(() -> "hello").thenApply(s -> s + " world").join();
        System.out.println(result);
    }

    @Test
    public void thenApply1() {
        CompletableFuture.supplyAsync(() -> "hello").thenAccept(s -> {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(s+" world!");});
    }

    @Test
    public void thenApply2() {
        thenApply();
        System.out.println("good");
        System.out.println("good");
        System.out.println("good");
    }

}
