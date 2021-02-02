package com.example.redis;

import cn.hutool.core.date.DateUtil;
import com.example.redis.bean.User;
import com.example.redis.component.RedisService;
import com.example.redis.dao.UserDao;
import com.example.redis.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SpringBootTest
class ZsetTests {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Test
    void contextLoads() {
    }

    @Test
    public void testAdd(){
        redisTemplate.opsForZSet().add("zset1", "will100", DateUtil.parse("2021-01-25", "yyyy-MM-dd").getTime());
        redisTemplate.opsForZSet().add("zset1", "will101", DateUtil.parse("2021-01-24", "yyyy-MM-dd").getTime());
        redisTemplate.opsForZSet().add("zset1", "will102", DateUtil.parse("2021-01-23", "yyyy-MM-dd").getTime());
        redisTemplate.opsForZSet().add("zset1", "will103", DateUtil.parse("2021-01-22", "yyyy-MM-dd").getTime());
    }

    @Test
    public void testGet(){
        Set<String> zset1 = redisTemplate.opsForZSet().rangeByScore("zset1", DateUtil.parse("2021-01-23", "yyyy-MM-dd").getTime(), DateUtil.parse("2021-01-24", "yyyy-MM-dd").getTime());
        assert zset1 != null;
        for(String obj : zset1){
            System.out.println(obj);
            redisTemplate.opsForZSet().remove("zset1", obj);
        }
    }

    @Test
    public void testGetAll(){
        Set<String> zset1 = redisTemplate.opsForZSet().range("zset1", 0, 100);
        assert zset1 != null;
        for(String obj : zset1){
            System.out.println(obj);
        }
    }

    @Test
    public void testDelete(){

    }

}
