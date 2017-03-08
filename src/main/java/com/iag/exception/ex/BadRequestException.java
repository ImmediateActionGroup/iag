package com.iag.exception.ex;


import com.iag.exception.enums.ExceptionEnum;

/**
 * Created by xueshan.wei on 11/14/2016.
 */
public class BadRequestException extends BusinessException {
    public BadRequestException() {
    }

    public BadRequestException(ExceptionEnum ee) {
        super(ee);
    }
}
