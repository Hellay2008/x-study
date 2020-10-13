package com.example.demo.controller;

import com.example.demo.TestBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController {

    @Resource
    TestBean testBean;

    @GetMapping("/test")
    public String test(){
        return testBean.getResult("will");
    }
}
