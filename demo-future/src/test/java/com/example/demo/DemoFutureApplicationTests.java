package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.CompletableFuture;

@SpringBootTest
class DemoFutureApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void test(){
        CompletableFuture.supplyAsync(() -> 2).thenApply(i->i+i).thenApply(i->i*3).whenComplete((r,e) -> {
            System.out.println(r);
        });
    }

}
