package com.example.demo.dao.impl;

import com.example.demo.dao.TestDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Slf4j
@Service("testDao")
public class TestDaoImpl implements TestDao {
    @Override
    public String getData(String id) {
        int cost = 2;
        log.info("param {}, start to query db", id);
        try {
            TimeUnit.SECONDS.sleep(cost);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("query data end, cost {}s", cost);
        return "hello-" + Math.random()*10;
    }
}
