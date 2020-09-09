package com.example.dp.factory.multi.factory;

import com.example.dp.factory.multi.service.Sender;
import com.example.dp.factory.multi.service.impl.MailSender;
import com.example.dp.factory.multi.service.impl.SmsSender;

public class SenderFactory {
    public Sender productMailSender() {
        return new MailSender();
    }
    public Sender productSmsSender() {
        return new SmsSender();
    }
}
