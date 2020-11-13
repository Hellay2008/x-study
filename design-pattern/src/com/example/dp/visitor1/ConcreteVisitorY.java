package com.example.dp.visitor1;
//具体的访问者X
public class ConcreteVisitorY implements Visitor{
    @Override
    public void visit(ConcreteElementA concreteElementA) {
        System.out.println("ConcreteVisitorY public void visit(ConcreteElementA concreteElementA) A=" + concreteElementA.toString());
        concreteElementA.operate();
    }

    @Override
    public void visit(ConcreteElementB concreteElementB) {
        System.out.println("ConcreteVisitorY public void visit(ConcreteElementA concreteElementA) B=" + concreteElementB.toString());
        concreteElementB.operate();
    }
}
