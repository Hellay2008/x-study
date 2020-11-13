package com.example.dp.visitor1;
//具体被访问者B
public class ConcreteElementB implements Element{

    private String name;

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void operate(){
        System.out.println("ConcreteElementB  public void operate()");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
