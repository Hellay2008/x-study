package com.example.dp.visitor1;
//具体的访问者X
public class ConcreteVisitorX implements Visitor{
    @Override
    public void visit(ConcreteElementA concreteElementA) {
        System.out.println("ConcreteVisitorX public void visit(ConcreteElementA concreteElementA) A=" + concreteElementA.toString());
        concreteElementA.operate();
    }

    @Override
    public void visit(ConcreteElementB concreteElementB) {
        System.out.println("ConcreteVisitorX public void visit(ConcreteElementA concreteElementA) B=" + concreteElementB.toString());
        concreteElementB.operate();
    }
}
