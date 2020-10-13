package com.example.dp.state;

public class ConcreteStateA extends State {

    @Override
    public String handle(String name) {
        String result = "helloA " + name;
        System.out.println("handled by ConcreteStateA : ");
        return result;
    }
}
