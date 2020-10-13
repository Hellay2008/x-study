package com.example.dp.visitor;

public interface ComputerPart {
    void accept(ComputerPartVisitor visitor);
}
