package com.iag.exception.ex;

import com.iag.exception.enums.ExceptionEnum;

/**
 * Created by beishan on 2017/3/19.
 */
public class ApiBusinessException extends CheckedException {

    public ApiBusinessException(){

    }

    public ApiBusinessException(ExceptionEnum ee){
        super(ee);
    }
}
