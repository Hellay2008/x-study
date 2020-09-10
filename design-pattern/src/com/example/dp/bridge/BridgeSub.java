package com.example.dp.bridge;

public class BridgeSub extends Bridge {
    public void method1(){
        getSource().method1();
    }
}
