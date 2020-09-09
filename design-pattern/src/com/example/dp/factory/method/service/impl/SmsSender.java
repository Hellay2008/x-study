package com.example.dp.factory.method.service.impl;

import com.example.dp.factory.method.service.Sender;

public class SmsSender implements Sender {
    @Override
    public void send() {
        System.out.println("send Sms message success");
    }
}
