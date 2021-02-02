package com.example.redis.service.impl;


import com.example.redis.bean.User;
import com.example.redis.component.RedisService;
import com.example.redis.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    RedisService redisService;

    private static final String KEY = "test-users";

    @Override
    public void setMultiUser(){

        String id = null;
        Map<String, Object> map = new HashMap<>();

        id = "1";
        User user = new User();
        user.setId(id);
        user.setName("name-"+id);
        user.setAge(Integer.parseInt(id));
        map.put(id, user);

        id = "2";
        user = new User();
        user.setId(id);
        user.setName("name-"+id);
        user.setAge(Integer.parseInt(id));
        map.put(id, user);

        id = "3";
        user = new User();
        user.setId(id);
        user.setName("name-"+id);
        user.setAge(Integer.parseInt(id));
        map.put(id, user);

        redisService.hPutAll(KEY, map);
        log.info("{} is set.", KEY);
    }

    @Override
    public void deleteKey() {
        log.info("key {} is deleted", KEY);
        redisService.delete(KEY);
    }

    private Map<String, User> getAllUser(String param1, String param2){
        String id = null;
        Map<String, User> map = new HashMap<>();

        id = "1";
        User user = new User();
        user.setId(id);
        user.setName("name-"+id);
        user.setAge(Integer.parseInt(id));
        map.put(id, user);

        id = "2";
        user = new User();
        user.setId(id);
        user.setName("name-"+id);
        user.setAge(Integer.parseInt(id));
        map.put(id, user);

        id = "3";
        user = new User();
        user.setId(id);
        user.setName("name-"+id);
        user.setAge(Integer.parseInt(id));
        map.put(id, user);

        return map;
    }

    private Map<String, User> getAllUser(){
        String id = null;
        Map<String, User> map = new HashMap<>();

        id = "1";
        User user = new User();
        user.setId(id);
        user.setName("name-"+id);
        user.setAge(Integer.parseInt(id));
        map.put(id, user);

        id = "2";
        user = new User();
        user.setId(id);
        user.setName("name-"+id);
        user.setAge(Integer.parseInt(id));
        map.put(id, user);

        id = "3";
        user = new User();
        user.setId(id);
        user.setName("name-"+id);
        user.setAge(Integer.parseInt(id));
        map.put(id, user);

        return map;
    }

}
