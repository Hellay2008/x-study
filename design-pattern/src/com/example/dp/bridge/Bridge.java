package com.example.dp.bridge;

public abstract class Bridge {
    private Sourceable source;

    public void method1(){
        source.method1();
    }

    public Sourceable getSource() {
        return source;
    }

    public void setSource(Sourceable source) {
        this.source = source;
    }
}
