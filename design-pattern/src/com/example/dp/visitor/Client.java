package com.example.dp.visitor;

public class Client {
    public static void main(String[] args) {
        Computer computer = new Computer();
        ComputerPartVisitor visitor = new ComputerPartVisitorImpl();
        computer.accept(visitor);
    }
}
