package com.example.demo.service;


import org.springframework.stereotype.Service;

//@Service("testService")
public class TestService {
    public String source = "definition";

    public String sayHello(){
        return "hello " + source;
    }
}
