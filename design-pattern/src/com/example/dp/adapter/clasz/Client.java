package com.example.dp.adapter.clasz;

public class Client {
    public static void main(String[] args) {
        Targetable targetable = new MyAdapter();
        targetable.method1();
        targetable.method2();
    }
}
