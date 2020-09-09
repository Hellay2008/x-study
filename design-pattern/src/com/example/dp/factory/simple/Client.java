package com.example.dp.factory.simple;

import com.example.dp.factory.simple.factory.SenderFactory;
import com.example.dp.factory.simple.service.Sender;

public class Client {
    public static void main(String[] args) {
        Sender sender;
        SenderFactory senderFactory = new SenderFactory();
        sender = senderFactory.product("mail");
        sender.send();

        sender = senderFactory.product("sms");
        sender.send();
    }
}
