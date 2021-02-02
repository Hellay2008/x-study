package com.anno;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

@API
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface APIK{
    @AliasFor("value")
    String value();
}
