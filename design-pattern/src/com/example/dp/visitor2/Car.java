package com.example.dp.visitor2;

import java.util.Arrays;

public class Car {

    private Body body;
    private Engine engine;
    private Wheel[] wheels;

    public Car(Body body, Engine engine, Wheel[] wheels){
        this.body = body;
        this.engine = engine;
        this.wheels = wheels;
    }


    public void accept(Visitor visitor){
        visitor.visit(this);
        body.accept(visitor);
        engine.accept(visitor);
        for(Wheel wheel : wheels){
            wheel.accept(visitor);
        }
    }
}
