package com.iag.annotation;

import com.iag.enums.log.SystemLog;

import java.lang.annotation.*;

/**
 * 日志记录类
 * Created by beishan on 2017/3/19.
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ControllerLog {
    SystemLog log() default SystemLog.DEFAULT;
}
