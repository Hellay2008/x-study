package com.example.dp.factory.staticf.service.impl;

import com.example.dp.factory.staticf.service.Sender;

public class MailSender implements Sender {
    @Override
    public void send() {
        System.out.println("send mail message success");
    }
}
