package com.example.dp.factory.staticf;

import com.example.dp.factory.staticf.factory.SenderFactory;
import com.example.dp.factory.staticf.service.Sender;

public class Client {
    public static void main(String[] args) {
        Sender mailSender = SenderFactory.productMailSender();
        Sender smsSender = SenderFactory.productSmsSender();
        mailSender.send();
        smsSender.send();
    }
}
