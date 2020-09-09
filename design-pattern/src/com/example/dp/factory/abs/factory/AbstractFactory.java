package com.example.dp.factory.abs.factory;

import com.example.dp.factory.abs.product.AbstractProductA;
import com.example.dp.factory.abs.product.AbstractProductB;

public abstract class AbstractFactory {
    //创建A产品
    public abstract AbstractProductA createProductA();

    //创建B产品
    public abstract AbstractProductB createProductB();
}
