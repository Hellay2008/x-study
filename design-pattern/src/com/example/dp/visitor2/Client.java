package com.example.dp.visitor2;

/**
 * https://zh.wikipedia.org/wiki/%E8%AE%BF%E9%97%AE%E8%80%85%E6%A8%A1%E5%BC%8F#Java%E7%9A%84%E4%BE%8B%E5%AD%90
 */
public class Client {
    public static void main(String[] args) {
        Body body = new Body();
        Wheel[] wheels = new Wheel[]{new Wheel("font-left"), new Wheel("font-right"),new Wheel("behind-left"),new Wheel("behind-right")};
        Engine engine = new Engine();
        Car car = new Car(body, engine, wheels);
        PrintVisitor printVisitor = new PrintVisitor();
        car.accept(printVisitor);
    }
}
