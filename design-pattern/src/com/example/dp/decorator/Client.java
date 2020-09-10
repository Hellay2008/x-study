package com.example.dp.decorator;

public class Client {
    public static void main(String[] args) {
        Sourceable sourceable = new Source();
        sourceable.method1();
        System.out.println("-----------------------");
        Sourceable decorator = new Decorator(sourceable);
        decorator.method1();
    }
}
