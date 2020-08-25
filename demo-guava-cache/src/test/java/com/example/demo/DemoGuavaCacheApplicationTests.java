package com.example.demo;

import com.google.common.cache.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@Slf4j
@SpringBootTest
class DemoGuavaCacheApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void testGuavaCache1(){
        Cache<String,String> cache = CacheBuilder.newBuilder().build();
        cache.put("word","Hello Guava Cache");
        System.out.println(cache.getIfPresent("word"));
        System.out.println(cache.getIfPresent("word"));
    }

    @Test
    public void testGuavaCacheLoading() throws Exception {
        LoadingCache<String, String> cache = CacheBuilder.newBuilder()
                .build(
                        new CacheLoader<String, String>() {
                            public String load(String key) throws Exception {
                                return createValue(key);
                            }
                        });
        long start = System.currentTimeMillis();
        String key = "world";
        String value = cache.get(key);
        long end = System.currentTimeMillis();
        log.info("key {}, value {}, cost {}", key, value, end - start);

    }

    @Test
    public void testGuavaCacheMaxsize(){
        Cache<String,String> cache = CacheBuilder.newBuilder()
                .maximumSize(2)
                .build();
        cache.put("key1","value1");
        cache.put("key2","value2");
        cache.put("key3","value3");
        System.out.println("第一个值：" + cache.getIfPresent("key1"));
        System.out.println("第二个值：" + cache.getIfPresent("key2"));
        System.out.println("第三个值：" + cache.getIfPresent("key3"));
    }

    @Test
    public void testGuavaCacheExpireAfterWrite() throws InterruptedException {
        Cache<String,String> cache = CacheBuilder.newBuilder()
                .maximumSize(2)
                .expireAfterWrite(3,TimeUnit.SECONDS)
                .build();
        cache.put("key1","value1");
        int time = 1;
        while(true) {
            System.out.println("第" + time++ + "次取到key1的值为：" + cache.getIfPresent("key1"));
            TimeUnit.SECONDS.sleep(1);
        }
    }

    @Test
    public void testGuavaCacheExpireAfterAccess() throws InterruptedException {
        Cache<String,String> cache = CacheBuilder.newBuilder()
                .maximumSize(2)
                .expireAfterAccess(5, TimeUnit.SECONDS)
                .build();
        cache.put("key1","value1");
        TimeUnit.SECONDS.sleep(6);
        System.out.println("取到key1的值为：" + cache.getIfPresent("key1"));
    }

    @Test
    public void testGuavaWeakReference(){
        Cache<String,Object> cache = CacheBuilder.newBuilder()
                .maximumSize(2)
                .weakValues()
                .build();
        Object value = new Object();
        cache.put("key1",value);

        log.info("has hard reference, cache.getIfPresent(\"key1\")={}", cache.getIfPresent("key1"));
        value = new Object();//原对象不再有强引用
        System.gc();
        log.info("no hard reference, cache.getIfPresent(\"key1\")={}", cache.getIfPresent("key1"));
    }

    @Test
    public void testGuavaClearKeys(){
        Cache<String,String> cache = CacheBuilder.newBuilder().build();
        cache.put("key1","value1");
        cache.put("key2","value2");
        cache.put("key3","value3");

        List<String> list = new ArrayList<String>();
        list.add("key1");
        list.add("key2");

        cache.invalidateAll(list);//批量清除list中全部key对应的记录
        System.out.println(cache.getIfPresent("key1"));
        System.out.println(cache.getIfPresent("key2"));
        System.out.println(cache.getIfPresent("key3"));
    }

    @Test
    public void testGuavaRemoveListener(){
        RemovalListener<String, String> listener = new RemovalListener<String, String>() {
            public void onRemoval(RemovalNotification<String, String> notification) {
                System.out.println("[" + notification.getKey() + ":" + notification.getValue() + "] is removed!");
            }
        };
        Cache<String,String> cache = CacheBuilder.newBuilder()
                .maximumSize(3)
                .removalListener(listener)
                .build();
        cache.put("key1","value1");
        cache.put("key2","value2");
        cache.put("key3","value3");
        cache.put("key4","value4");
        cache.put("key5","value5");
        cache.put("key6","value6");
        cache.put("key7","value7");
        cache.put("key8","value8");
    }

    @Test
    public void testGuavaStatics(){
        Cache<String,String> cache = CacheBuilder.newBuilder()
                .maximumSize(3)
                .recordStats() //开启统计信息开关
                .build();
        cache.put("key1","value1");
        cache.put("key2","value2");
        cache.put("key3","value3");
        cache.put("key4","value4");

        cache.getIfPresent("key1");
        cache.getIfPresent("key2");
        cache.getIfPresent("key3");
        cache.getIfPresent("key4");
        cache.getIfPresent("key5");
        cache.getIfPresent("key6");

        System.out.println(cache.stats()); //获取统计信息
    }

    @Test
    public void testGuavaLoadingCache() throws ExecutionException {
        CacheLoader<String, String> loader = new CacheLoader<String, String> () {
            public String load(String key) throws Exception {
                Thread.sleep(1000); //休眠1s，模拟加载数据
                System.out.println(key + " is loaded from a cacheLoader!");
                return key + "'s value";
            }
        };

        LoadingCache<String,String> loadingCache = CacheBuilder.newBuilder()
                .maximumSize(3)
                .build(loader);//在构建时指定自动加载器

        loadingCache.get("key1");
        loadingCache.get("key2");
        loadingCache.get("key3");
    }

    @Test
    public void testGuavaLoadingCache1() throws InterruptedException, ExecutionException {
        CacheLoader<String, String> loader = new CacheLoader<String, String> () {
            public String load(String key) throws Exception {
                Thread.sleep(1000); //休眠1s，模拟加载数据
                System.out.println(key + " is loaded from a cacheLoader!");
                return key + "'s value";
            }
        };

        LoadingCache<String,String> loadingCache = CacheBuilder.newBuilder()
                .maximumSize(10)
                .build(loader);//在构建时指定自动加载器
        log.info("loadingCache.getIfPresent(\"key1\")={}", loadingCache.getIfPresent("key1"));
        log.info("loadingCache.getIfPresent(\"key2\")={}", loadingCache.getIfPresent("key2"));
        log.info("loadingCache.getIfPresent(\"key3\")={}", loadingCache.getIfPresent("key3"));
        log.info("loadingCache.getIfPresent(\"key4\")={}", loadingCache.getIfPresent("key4"));
        TimeUnit.SECONDS.sleep(5);
        log.info("loadingCache.getIfPresent(\"key1\")={}", loadingCache.get("key1"));
        log.info("loadingCache.getIfPresent(\"key2\")={}", loadingCache.getIfPresent("key2"));
        log.info("loadingCache.getIfPresent(\"key3\")={}", loadingCache.getIfPresent("key3"));
        log.info("loadingCache.getIfPresent(\"key4\")={}", loadingCache.getIfPresent("key4"));

    }










    public String createValue(String key) throws InterruptedException {
        TimeUnit.SECONDS.sleep(10);
        return "hello " + key;
    }



}
