package com.example.dp.factory.abs;

import com.example.dp.factory.abs.creator.AbstractFactory;
import com.example.dp.factory.abs.creator.ConcreteFactory1;
import com.example.dp.factory.abs.creator.ConcreteFactory2;
import com.example.dp.factory.abs.product.AbstractProductA;
import com.example.dp.factory.abs.product.AbstractProductB;

public class Client {
    public static void main(String[] args) {
        AbstractFactory creator1 = new ConcreteFactory1();
        AbstractFactory creator2 = new ConcreteFactory2();

        AbstractProductA a1 = creator1.createProductA();
        AbstractProductB b1 = creator1.createProductB();

        AbstractProductA a2 = creator2.createProductA();
        AbstractProductB b2 = creator2.createProductB();

        a1.doSomething();
        b1.doSomething();

        a2.doSomething();
        b2.doSomething();
    }
}
