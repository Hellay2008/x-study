package com.example.dp.factory.abs1.product;

public abstract class AbstractOrderService {
    //订单共有的方法
    public void orderShareMethod() {
    }

    // 订单相同方法，不同实现
    public abstract void getOrder();
}
