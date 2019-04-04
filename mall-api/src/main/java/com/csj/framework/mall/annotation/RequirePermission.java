package com.csj.framework.mall.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface RequirePermission {

    String value() default "";

    String[] permissions() default {};


}
