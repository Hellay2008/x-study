package com.example.dp.adapter.jiekou;

public class Client {
    public static void main(String[] args) {
        Sourceable s1 = new SourceSub1();
        Sourceable s2 = new SourceSub2();
        s1.method1();
        s2.method2();
    }
}
