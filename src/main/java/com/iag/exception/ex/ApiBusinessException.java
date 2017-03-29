package com.iag.exception.ex;

import com.iag.exception.enums.ExceptionEnum;
import org.springframework.validation.BindingResult;

/**
 * Created by beishan on 2017/3/19.
 */
public class ApiBusinessException extends CheckedException {
    private BindingResult bindingResult;

    public ApiBusinessException(){

    }

    public ApiBusinessException(ExceptionEnum ee){
        super(ee);
    }

    public ApiBusinessException(ExceptionEnum ee, BindingResult bindingResult){
        super(ee);
        this.bindingResult = bindingResult;
    }
}
