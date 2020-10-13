package com.example.redis.aspect;

import cn.hutool.extra.spring.SpringUtil;
import com.example.redis.annotation.CacheableMap;
import com.example.redis.component.RedisService;
import com.example.redis.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Map;


//描述切面类
@Slf4j
@Aspect
@Component
public class CacheableMapAspect {

    @Autowired
    RedisService redisService;

    /*
     * 定义一个切入点
     */
    @Pointcut("@annotation(com.example.redis.annotation.CacheableMap)")
    public void cacheableMapPointCut() {

    }

    @Around("cacheableMapPointCut()")
    public Object around(ProceedingJoinPoint thisJoinPoint) throws Throwable {
        Object[] args = thisJoinPoint.getArgs();
        MethodSignature joinPointObject = (MethodSignature) thisJoinPoint.getSignature();
        Method method = joinPointObject.getMethod();
        CacheableMap annotation = method.getAnnotation(CacheableMap.class);
        if (!redisService.hasKey(annotation.key())) {
            Object result = thisJoinPoint.proceed(args);
            redisService.hPutAll(annotation.key(), (Map<String, Object>) result);
        }
        return redisService.hMultiGet(annotation.key(), (Collection<Object>) args[annotation.paramIndex()]);
    }

}