package com.example.redis.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageReceiver {
    /**
     * 接受监听到的消息
     */
    public void receiveMessage1(String message) {
        log.info("接收redis通道消息1：" + message);
    }
    public void receiveMessage2(String message) {
        log.info("接收redis通道消息2：" + message);
    }
}
