package com.iag.annotation;

import java.lang.annotation.*;

/**
 * 小黑屋检查注解，标注了改注解的方法都需要检查该用户是否被关在小黑屋里
 * 以至于不能进行某种操作，比如发帖等
 * Created by xueshan.wei on 3/22/2017.
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DarkroomCheck {

}
