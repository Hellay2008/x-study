package com.example.dp.facade;

import java.util.concurrent.CompletableFuture;

public class Client {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.startup();
        System.out.println("------------");
        System.out.println("------------");
        System.out.println("------------");
        System.out.println("------------");
        computer.shutdown();
    }
}
