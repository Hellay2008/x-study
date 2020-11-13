package com.example.dp.visitor2;

public class Body {
    public void accept(Visitor visitor){
        visitor.visit(this);
    }
}
