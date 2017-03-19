package com.iag.annotation;

import java.lang.annotation.*;

/**
 * 权限检查注解类
 * Created by beishan on 2017/3/19.
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AuthorityCheck {
    String [] permission () default "";
}
