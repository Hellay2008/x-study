package com.example.redis;

import com.example.redis.bean.User;
import com.example.redis.component.RedisService;
import com.example.redis.dao.UserDao;
import com.example.redis.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@SpringBootTest
class DemoRedisApplicationTests {

    @Autowired
    UserDao userDao;
    @Autowired
    UserService userService;
    @Autowired
    RedisService redisService;

    @Test
    void contextLoads() {
    }

    @Test
    public void testCacheAnnotationSelectById(){
        userDao.delete("1");
        userDao.selectUserById("1");
        userDao.selectUserById("1");
        userDao.selectUserById("1");
    }

    @Test
    public void deleteKey(){
        userService.deleteKey();
    }

    @Test
    public void setMapTest(){
        userService.setMultiUser();
    }

/*    @Test
    public void multiGetTest(){
        List<Object> ids = Arrays.asList("1", "2");
        userService.multiGet(ids);
    }

    @Test
    public void multiGetTest1(){
       Map<String, User> list = (Map<String, User>) redisService.get("test-users-map");
       System.out.println(list.size());
    }

    @Test
    public void multiGetTest2(){
        List<String> ids = Arrays.asList("1", "2");
        userService.multiGet2("hello", "world", ids);
    }*/

    @Test
    public void testRedisPubSub(){
        redisService.publishMessage("test-topic", "well done");
    }

}
