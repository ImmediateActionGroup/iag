package com.iag.exception.ex;


import com.iag.exception.enums.ExceptionEnum;

/**
 * Created by xueshan.wei on 11/14/2016.
 */
public class DataBaseException extends NotBusinessException {
    public DataBaseException() {
    }

    public DataBaseException(ExceptionEnum ee) {
        super(ee);
    }
}
