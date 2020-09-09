package com.example.dp.factory.abs1.factory;

import com.example.dp.factory.abs1.product.AbstractProductService;
import com.example.dp.factory.abs1.product.AbstractOrderService;
import com.example.dp.factory.abs1.product.ProductService2;
import com.example.dp.factory.abs1.product.OrderService2;

public class ConcreteFactory2 extends AbstractFactory {
    @Override
    public AbstractProductService createProductService() {
        return new ProductService2();
    }

    @Override
    public AbstractOrderService createOrderService() {
        return new OrderService2();
    }
}
