package com.example.redis.service.impl;


import com.example.redis.annotation.CacheableMap;
import com.example.redis.annotation.I19n;
import com.example.redis.bean.User;
import com.example.redis.component.RedisService;
import com.example.redis.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    RedisService redisService;

    private static final String KEY = "test-users";
    private static final String KEY1 = "test-users-map";

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
    @I19n(key="test-users")
    public void multiGet(List<Object> ids){
        List<Object> list = redisService.hMultiGet(KEY, ids);
        for(Object e : list){
            log.info(e.toString());
        }
    }

/*    public List<String, User> multiGet1(List<Object> ids){
        if(!redisService.hasKey("key")) {
            Map<String, User> map = getAllUser();
            redisService.hPutAll("key", map);
            Map<String, User> result = new HashMap<>();
            for (Object id : ids) {
                if (map.containsKey((String)id)) {
                    result.put((String)id, map.get(id));
                }
            }
            return result;
        }else{
            return (List<String, User>) redisService.hMultiGet(KEY, ids);
        }
    }*/

    @CacheableMap(key="test-users2", paramIndex=3)
    public Map<String, User> multiGet2(String param1, String param2, List<String> ids){
        log.info("multiGet2 will call getAllUser(param1, param2)");
        return getAllUser(param1, param2);
    }

    @CacheableMap(key="test-users3", paramIndex=3, initBeanName = "userService", initMethodName = "getAllUser")
    public Map<String, User> multiGet3(List<String> ids){

        return null;
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
