package com.example.dp.factory.abs1.factory;

import com.example.dp.factory.abs1.product.AbstractProductService;
import com.example.dp.factory.abs1.product.AbstractOrderService;

public abstract class AbstractFactory {
    //创建产品服务
    public abstract AbstractProductService createProductService();

    //创建订单服务
    public abstract AbstractOrderService createOrderService();
}
