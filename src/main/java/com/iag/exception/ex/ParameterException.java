package com.iag.exception.ex;

import com.iag.exception.enums.ExceptionEnum;

/**
 * Created by xueshan.wei on 11/14/2016.
 */
public class ParameterException extends BadRequestException {
    public ParameterException() {
    }

    public ParameterException(ExceptionEnum ee) {
        super(ee);
    }
}
