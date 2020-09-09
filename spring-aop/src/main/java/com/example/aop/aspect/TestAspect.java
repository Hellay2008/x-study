package com.example.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


//描述切面类
@Aspect
@Component
public class TestAspect {

    /*
     * 定义一个切入点
     */
    @Pointcut("@annotation(com.example.aop.annotation.MyAsync)")
    public void myPointcut() {

    }

    @Around("myPointcut()")
    public void around(ProceedingJoinPoint thisJoinPoint){
        Object[] args = thisJoinPoint.getArgs();
        for(Object arg : args){
            if(arg instanceof String){
                System.out.println("find a String arg: " + arg);
            }
        }
    }

    @Before("myPointcut()")
    public void before(){
        System.out.println(Thread.currentThread().getName() + ": before say hello");
    }

    @After("myPointcut()")
    public void after(){
        System.out.println(Thread.currentThread().getName() + ": after say hello");
    }

}