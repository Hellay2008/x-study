package com.example.dp.statik;

public class Proxy implements Sourceable {
    private final Source source;

    public Proxy(){
        this.source = new Source();
    }
    @Override
    public void method1() {
        System.out.println("before source");
        source.method1();
        System.out.println("after source");
    }
}
