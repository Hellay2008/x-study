package com.example.dp.factory.method.factory;

import com.example.dp.factory.method.service.Sender;
import com.example.dp.factory.method.service.impl.MailSender;

public class MailSenderFactory implements SenderProvider{
    @Override
    public Sender produce() {
        return new MailSender();
    }
}
