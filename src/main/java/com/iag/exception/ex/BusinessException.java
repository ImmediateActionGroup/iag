package com.iag.exception.ex;

import com.iag.exception.enums.ExceptionEnum;

/**
 * Created by xueshan.wei on 11/14/2016.
 */
public class BusinessException extends CheckedException {
    public BusinessException() {
    }

    public BusinessException(ExceptionEnum ee) {
        super(ee);
    }
}
