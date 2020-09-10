package com.example.dp.decorator;

public class Decorator implements Sourceable {
    private Sourceable sourceable;

    public Decorator(Sourceable sourceable){
        this.sourceable = sourceable;
    }

    @Override
    public void method1() {
        System.out.println("decorator method1 before");
        sourceable.method1();
        System.out.println("decorator method1 after");
    }
}
