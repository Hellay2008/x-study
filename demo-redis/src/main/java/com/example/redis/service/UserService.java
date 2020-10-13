package com.example.redis.service;

import com.example.redis.annotation.CacheableMap;
import com.example.redis.bean.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    void setMultiUser();
    void multiGet(List<Object> ids);
//    List<Object> multiGet1(List<Object> ids);
    void deleteKey();

    Map<String, User> multiGet2(String param1, String param2, List<String> ids);

    Map<String, User> multiGet3(List<String> ids);
}
