package com.example.dp.factory.staticf.factory;

import com.example.dp.factory.staticf.service.Sender;
import com.example.dp.factory.staticf.service.impl.MailSender;
import com.example.dp.factory.staticf.service.impl.SmsSender;

public class SenderFactory {
    public static Sender productMailSender() {
        return new MailSender();
    }
    public static Sender productSmsSender() {
        return new SmsSender();
    }
}
