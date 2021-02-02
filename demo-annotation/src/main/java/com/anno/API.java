package com.anno;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Repeatable(APIS.class)
@Target(ElementType.TYPE)
public @interface API {
    String value() default "";
}
