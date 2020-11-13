package com.example.dp.visitor1;

import com.sun.media.jfxmedia.events.VideoTrackSizeListener;

public class Client {
    public static void main(String[] args) {
        ConcreteElementA elementA = new ConcreteElementA();
        ConcreteElementB elementB = new ConcreteElementB();

        Visitor visitorX = new ConcreteVisitorX();
        Visitor visitorY = new ConcreteVisitorY();

        elementA.accept(visitorX);
        elementA.accept(visitorY);
        System.out.println("--------------------");
        elementB.accept(visitorX);
        elementB.accept(visitorY);
    }
}
