package com.example.dp.state;

public class ConcreteStateB extends State {

    @Override
    public String handle(String name) {
        String result = "helloB " + name;
        System.out.println("handled by ConcreteStateB : ");
        return result;
    }
}
