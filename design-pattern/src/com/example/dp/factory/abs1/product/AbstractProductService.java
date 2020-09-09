package com.example.dp.factory.abs1.product;

public abstract class AbstractProductService {
    //产品服务共有的方法
    public void shareMethod() {
    }

    // 产品服务相同方法，不同实现
    public abstract void getProduct();
}
