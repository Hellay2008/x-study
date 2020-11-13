package com.example.dp.visitor2;

public class PrintVisitor implements Visitor{
    @Override
    public void visit(Wheel wheel) {
        System.out.println("Visit wheel " + wheel.getName());
    }

    @Override
    public void visit(Engine engine) {
        System.out.println("visit engine");
    }

    @Override
    public void visit(Body body) {
        System.out.println("visit body");
    }

    @Override
    public void visit(Car car) {
        System.out.println("visit car");
    }
}
