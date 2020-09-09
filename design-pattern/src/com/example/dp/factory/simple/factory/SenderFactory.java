package com.example.dp.factory.simple.factory;

import com.example.dp.factory.simple.service.Sender;
import com.example.dp.factory.simple.service.impl.MailSender;
import com.example.dp.factory.simple.service.impl.SmsSender;

public class SenderFactory {
    public Sender product(String type) {
        Sender sender = null;
        switch (type){
            case "mail":
                sender =  new MailSender();
                break;
            case "sms":
                sender =  new SmsSender();
                break;
            default:
        }
        return sender;
    }
}
