package com.example.dp.factory.method;

import com.example.dp.factory.method.factory.MailSenderFactory;
import com.example.dp.factory.method.factory.SmsSenderFactory;
import com.example.dp.factory.method.service.Sender;

public class Client {
    public static void main(String[] args) {
        MailSenderFactory senderFactory = new MailSenderFactory();
        Sender mailSender = senderFactory.produce();
        mailSender.send();

        SmsSenderFactory smsSenderFactory = new SmsSenderFactory();
        Sender smsSender = smsSenderFactory.produce();
        smsSender.send();
    }
}
