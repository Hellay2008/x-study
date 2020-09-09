package com.example.demo.service.impl;


import com.alicp.jetcache.anno.*;
import com.example.demo.dao.TestDao;
import com.example.demo.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service("testService")
public class TestServiceImpl implements TestService {

    @Resource(name = "testDao")
    TestDao testDao;

    @Override
    @Cached(name="local-cache-", cacheType = CacheType.REMOTE, key = "#id")
    @CacheRefresh(refresh = 20, timeUnit = TimeUnit.SECONDS)
    public String testLocalCache(String id) {
        log.error("local-cache failed, try to access db");
        return testDao.getData("local-" + id);
    }

    @Override
    @Cached(name="remote-cache-", cacheType = CacheType.REMOTE, key = "#id")
    @CacheRefresh(refresh = 20, timeUnit = TimeUnit.SECONDS)
    public String testRemoteCache(String id) {
        log.error("remote-cache failed, try to access db");
        return testDao.getData("remote-" + id);
    }

    @Override
    @Cached(name="both-cache-", cacheType = CacheType.BOTH, key = "#id")
    @CacheRefresh(refresh = 60, timeUnit = TimeUnit.SECONDS)
    public String testBothCache(String id) {
        log.error("both-cache failed, try to access db");
        return testDao.getData("both-" + id);
    }

    @Override
    @CacheInvalidate(name="remote-cache-", key = "#id")
    public String deleteRemote(String id){
        return "remote-cache-" + id + " is deleted";
    }

    @Override
    @CacheInvalidate(name="local-cache-", key = "#id")
    public String deleteLocal(String id){
        return "local-cache-" + id + " is deleted";
    }

    @Override
    @CacheInvalidate(name="both-cache-", key = "#id")
    public String deleteBoth(String id){
        return "both-cache-" + id + " is deleted";
    }

}
