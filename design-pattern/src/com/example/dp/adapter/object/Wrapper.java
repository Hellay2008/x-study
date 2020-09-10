package com.example.dp.adapter.object;

public class Wrapper implements Targetable {

    Source source;

    public Wrapper(Source source){
        this.source = source;
    }

    @Override
    public void method1() {
        source.method1();
    }

    @Override
    public void method2() {
        System.out.println("this is wrapper method");
    }
}
