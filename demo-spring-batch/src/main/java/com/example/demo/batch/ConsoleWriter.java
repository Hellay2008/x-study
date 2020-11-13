package com.example.demo.batch;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

@Slf4j
public class ConsoleWriter implements ItemWriter<String> {
    @Override
    public void write(List<? extends String> list) {
        for (String msg :list) {
            log.debug("write data: "+msg);
        }
    }
}
