package com.example.dp.visitor1;
//具体被访问者A
public class ConcreteElementA implements Element{

    private String name;

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void operate(){
        System.out.println("ConcreteElementA  public void operate()");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
