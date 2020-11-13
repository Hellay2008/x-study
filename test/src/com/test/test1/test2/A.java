package com.test.test1.test2;

public class A implements I{
    public void get(){
        System.out.println("A->get()");
    }

    public void getX(){
        get();
    }

    public void test(){
        get();
    }
}
