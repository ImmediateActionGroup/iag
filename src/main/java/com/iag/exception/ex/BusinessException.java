package com.iag.exception.ex;


import com.iag.exception.enums.ExceptionEnum;

/**
 * Created by beishan on 2017/3/8.
 */
public class BusinessException extends CheckedException {

    public BusinessException(){

    }

    public BusinessException(ExceptionEnum ee){
        super(ee);
    }
}
