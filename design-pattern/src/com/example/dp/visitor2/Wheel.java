package com.example.dp.visitor2;

public class Wheel {
    private String name;

    public Wheel(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void accept(Visitor visitor){
        visitor.visit(this);
    }
}
