package com.iag.exception.ex;


import com.iag.exception.enums.ExceptionEnum;

/**
 * Created by beishan on 2017/3/8.
 */
public class DataBaseException extends BusinessException {
    public DataBaseException(){

    }

    public DataBaseException(ExceptionEnum ee){
        super(ee);
    }
}
