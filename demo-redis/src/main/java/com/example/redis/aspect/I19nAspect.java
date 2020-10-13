package com.example.redis.aspect;

import com.example.redis.component.RedisService;
import com.example.redis.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


//描述切面类
@Slf4j
@Aspect
@Component
public class I19nAspect {

    @Autowired
    UserService userService;

    @Autowired
    RedisService redisService;

    private static final String KEY = "test-users";

    /*
     * 定义一个切入点
     */
    @Pointcut("@annotation(com.example.redis.annotation.I19n)")
    public void myPointcut() {

    }

    @Around("myPointcut()")
    public void around(ProceedingJoinPoint thisJoinPoint) throws Throwable {
        log.info("@Around before");
        Object[] args = thisJoinPoint.getArgs();
//        for(Object arg : args){
//            if(arg instanceof String){
//                System.out.println("find a String arg: " + arg);
//            }
//        }
        thisJoinPoint.proceed(args);
        log.info("@Around after");
    }

    @Before("myPointcut()")
    public void before(){
        log.info("@before before");
        if(redisService.hasKey(KEY)){
            log.info("key {} exists.", KEY);
            return;
        }
        log.info("key {} is not exists.", KEY);
        userService.setMultiUser();
    }

    @After("myPointcut()")
    public void after(){
        log.info("@After after");

    }

}