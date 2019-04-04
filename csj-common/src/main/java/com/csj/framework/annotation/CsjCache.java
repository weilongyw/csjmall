package com.csj.framework.annotation;


import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface CsjCache {

    String cacheName();

    String key();

    boolean needLog();


}
