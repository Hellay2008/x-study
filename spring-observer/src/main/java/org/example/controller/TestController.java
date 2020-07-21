package org.example.controller;

import org.example.event.CustomEvent;
import org.example.service.MyPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    MyPublisher myPublisher;

    @RequestMapping("/test/publisher")
    public String publish(){
        myPublisher.publishEvent(new CustomEvent(this));
        return "good";
    }
}
