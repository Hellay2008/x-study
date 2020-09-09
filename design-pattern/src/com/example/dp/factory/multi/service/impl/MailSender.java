package com.example.dp.factory.multi.service.impl;

import com.example.dp.factory.multi.service.Sender;

public class MailSender implements Sender {
    @Override
    public void send() {
        System.out.println("send mail message success");
    }
}
