package com.example.dp.factory.method.factory;

import com.example.dp.factory.method.service.Sender;
import com.example.dp.factory.method.service.impl.MailSender;
import com.example.dp.factory.method.service.impl.SmsSender;

public class SmsSenderFactory implements SenderProvider{
    @Override
    public Sender produce() {
        return new SmsSender();
    }
}
