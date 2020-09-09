package com.example.dp.factory.simple.service.impl;

import com.example.dp.factory.simple.service.Sender;

public class SmsSender implements Sender {
    @Override
    public void send() {
        System.out.println("send Sms message success");
    }
}
