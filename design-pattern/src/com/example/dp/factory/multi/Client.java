package com.example.dp.factory.multi;

import com.example.dp.factory.multi.factory.SenderFactory;
import com.example.dp.factory.multi.service.Sender;

public class Client {
    public static void main(String[] args) {
        SenderFactory senderFactory = new SenderFactory();
        Sender mailSender = senderFactory.productMailSender();
        Sender smsSender = senderFactory.productSmsSender();
        mailSender.send();
        smsSender.send();
    }
}
