package com.example.dp.visitor;

public class ComputerPartVisitorImpl implements ComputerPartVisitor{

    @Override
    public void visit(Computer computer) {
        System.out.println("visit Computer");
    }

    @Override
    public void visit(Mouse mouse) {
        System.out.println("visit Mouse");
    }

    @Override
    public void visit(KeyBoard keyBoard) {
        System.out.println("visit KeyBoard");
    }
}
