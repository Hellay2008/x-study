package com.example.dp.factory.abs.factory;

import com.example.dp.factory.abs.product.AbstractProductA;
import com.example.dp.factory.abs.product.AbstractProductB;
import com.example.dp.factory.abs.product.ProductA1;
import com.example.dp.factory.abs.product.ProductB1;

public class ConcreteFactory1 extends AbstractFactory {
    @Override
    public AbstractProductA createProductA() {
        return new ProductA1();
    }

    @Override
    public AbstractProductB createProductB() {
        return new ProductB1();
    }
}
