package com.example.demo.batch;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ConsoleService {
    public String convert2UpperCase(String word){
        return Optional.ofNullable(word).orElse("").toUpperCase();
    }
}
