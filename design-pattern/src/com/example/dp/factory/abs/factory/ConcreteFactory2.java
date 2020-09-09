package com.example.dp.factory.abs.factory;

import com.example.dp.factory.abs.product.AbstractProductA;
import com.example.dp.factory.abs.product.AbstractProductB;
import com.example.dp.factory.abs.product.ProductA2;
import com.example.dp.factory.abs.product.ProductB2;

public class ConcreteFactory2 extends AbstractFactory {
    @Override
    public AbstractProductA createProductA() {
        return new ProductA2();
    }

    @Override
    public AbstractProductB createProductB() {
        return new ProductB2();
    }
}
