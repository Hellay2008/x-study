package com.example.dp.factory.abs1;

import com.example.dp.factory.abs1.factory.AbstractFactory;
import com.example.dp.factory.abs1.factory.ConcreteFactory1;
import com.example.dp.factory.abs1.factory.ConcreteFactory2;
import com.example.dp.factory.abs1.product.AbstractProductService;
import com.example.dp.factory.abs1.product.AbstractOrderService;

public class Client {
    public static void main(String[] args) {
        AbstractFactory factory1 = new ConcreteFactory1();
        AbstractFactory factory2 = new ConcreteFactory2();

        AbstractProductService productService1 = factory1.createProductService();
        AbstractOrderService orderService1 = factory1.createOrderService();

        AbstractProductService productService2 = factory2.createProductService();
        AbstractOrderService orderService2 = factory2.createOrderService();

        productService1.getProduct();
        orderService1.getOrder();

        productService2.getProduct();
        orderService2.getOrder();


    }
}
