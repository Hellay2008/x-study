package com.example.dp.factory.abs1.factory;

import com.example.dp.factory.abs1.product.AbstractProductService;
import com.example.dp.factory.abs1.product.AbstractOrderService;
import com.example.dp.factory.abs1.product.ProductService1;
import com.example.dp.factory.abs1.product.OrderService1;

public class ConcreteFactory1 extends AbstractFactory {
    @Override
    public AbstractProductService createProductService() {
        return new ProductService1();
    }

    @Override
    public AbstractOrderService createOrderService() {
        return new OrderService1();
    }
}
