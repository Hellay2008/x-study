package com.example.redis.dao;

import com.example.redis.bean.User;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;



public interface UserDao {

    User selectUserById(String id);

    List<User> selectUser();

    User insert(User user);

    User update(User user);

    void delete(String id);
}