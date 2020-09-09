package com.example.dp.factory.method.factory;

import com.example.dp.factory.method.service.Sender;

public interface SenderProvider {
    Sender produce();
}
