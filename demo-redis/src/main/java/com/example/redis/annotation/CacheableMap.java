package com.example.redis.annotation;

import org.springframework.scheduling.annotation.Async;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Async
public @interface CacheableMap {
    String key() default "";
    int paramIndex() default 0;
    String initBeanName() default "";
    String initMethodName() default "";
}