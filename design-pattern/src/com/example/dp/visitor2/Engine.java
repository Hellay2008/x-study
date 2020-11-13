package com.example.dp.visitor2;

public class Engine {

    public void accept(Visitor visitor){
        visitor.visit(this);
    }
}
