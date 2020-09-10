package com.example.dp.bridge;

public class Client {

    public static void main(String[] args) {
        Sourceable source1 = new SourceSub1();
        Bridge bridge = new BridgeSub();
        bridge.setSource(source1);
        bridge.method1();

        Sourceable source2 = new SourceSub2();
        bridge.setSource(source2);
        bridge.method1();
    }
}
