package com.yj2.leave.util.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RequireLogin {
    //是否需要检查登录(默认为true)
    public boolean check() default true;

    //是否一定要登录
    public boolean require() default true;
}
