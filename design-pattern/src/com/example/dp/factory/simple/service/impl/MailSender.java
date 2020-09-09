package com.example.dp.factory.simple.service.impl;

import com.example.dp.factory.simple.service.Sender;

public class MailSender implements Sender {
    @Override
    public void send() {
        System.out.println("send mail message success");
    }
}
