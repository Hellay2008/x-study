package com.example.demo;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.CreateCache;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

@Slf4j
@SpringBootTest
class DemoJetcacheApplicationTests {

    @Test
    void contextLoads() {
    }

    @CreateCache(expire = 10, timeUnit = TimeUnit.SECONDS, cacheType = CacheType.LOCAL)
    private Cache<Long, String> userCache;

    @Test
    public void test() throws InterruptedException {

        Long key = 1L;
        userCache.put(key, key+"");
        TimeUnit.SECONDS.sleep(11);
        log.info("key={}, value={}", key, userCache.get(key));

        key = 2L;
        userCache.put(key, key+"");
        TimeUnit.SECONDS.sleep(5);

        key = 3L;
        userCache.put(key, key+"");
        TimeUnit.SECONDS.sleep(6);
        key = 4L;
        userCache.put(key, key+"");
        log.info("key={}, value={}", 2L, userCache.get(2L));
        log.info("key={}, value={}", 3L, userCache.get(3L));
        log.info("key={}, value={}", 4L, userCache.get(4L));


    }

}
