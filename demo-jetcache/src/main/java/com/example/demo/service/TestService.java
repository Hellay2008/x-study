package com.example.demo.service;

import com.alicp.jetcache.anno.CacheInvalidate;

public interface TestService {
    String testLocalCache(String id);
    String testRemoteCache(String id);
    String testBothCache(String id);

    String deleteRemote(String id);
    String deleteLocal(String id);
    String deleteBoth(String id);

    String setValueByKey(String key);
    void deleteAll();
}
