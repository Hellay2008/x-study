package com.example.dp.adapter.object;

public class Client {


    public static void main(String[] args) {
        Targetable targetable = new Wrapper(new Source());
        targetable.method1();
        targetable.method2();
    }
}
