package com.example.dp.visitor1;
// 抽象被访问者
public interface Element {
    void accept(Visitor visitor);
}
