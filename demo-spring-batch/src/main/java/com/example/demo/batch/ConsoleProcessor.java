package com.example.demo.batch;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class ConsoleProcessor implements ItemProcessor<String,String> {
    @Autowired
    private ConsoleService consoleService;
    @Override
    public String process(String data) {
        String dataProcessed = consoleService.convert2UpperCase(data);
        log.debug(data +" process data --> " + dataProcessed);
        return dataProcessed;
    }
}