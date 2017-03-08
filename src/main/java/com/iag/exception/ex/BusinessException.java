package com.iag.exception.ex;

import com.iag.enums.exception.ExceptionEnum;

/**
 * Created by beishan on 2017/3/8.
 */
public class BusinessException extends Exception {
    protected ExceptionEnum ee;

    public BusinessException(){

    }

    public BusinessException(ExceptionEnum ee){
        super(ee.getCode() + "----" + ee.getMsg());
        this.ee = ee;
    }
}
