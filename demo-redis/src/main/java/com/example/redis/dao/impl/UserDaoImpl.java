package com.example.redis.dao.impl;

import com.example.redis.bean.User;
import com.example.redis.dao.UserDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@CacheConfig(cacheNames = "users")
@Slf4j
public class UserDaoImpl implements UserDao {

    @Override
    @Cacheable(key ="#id")
    public User selectUserById(String id) {
        log.info("mock select user from db with id {}", id);
        User user = new User();
        user.setId(id);
        user.setName("name-"+id);
        user.setAge(Integer.parseInt(id));
        return user;
    }

    @Override
    @Cacheable(key ="'list'")
    public List<User> selectUser() {
        log.info("mock select users from db");
        String id = null;
        List<User> list = new ArrayList<>();

        id = "1";
        User user = new User();
        user.setId(id);
        user.setName("name-"+id);
        user.setAge(Integer.parseInt(id));
        list.add(user);

        id = "2";
        user = new User();
        user.setId(id);
        user.setName("name-"+id);
        user.setAge(Integer.parseInt(id));
        list.add(user);

        id = "3";
        user = new User();
        user.setId(id);
        user.setName("name-"+id);
        user.setAge(Integer.parseInt(id));
        list.add(user);

        return list;
    }

    @Override
    @CachePut(key = "#user.id")
    public User insert(User user) {
        log.info("mock insert user into db {}", user);
        return user;
    }

    @Override
    @CachePut(key = "#user.id")
    public User update(User user) {
        log.info("mock update user into db {}", user);
        return user;
    }

    @Override
    @CacheEvict(key = "#id")
    public void delete(String id) {
        log.info("mock delete user in db with id {}", id);
    }
}
