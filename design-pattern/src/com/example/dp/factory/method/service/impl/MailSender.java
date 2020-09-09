package com.example.dp.factory.method.service.impl;

import com.example.dp.factory.method.service.Sender;

public class MailSender implements Sender {
    @Override
    public void send() {
        System.out.println("send mail message success");
    }
}
