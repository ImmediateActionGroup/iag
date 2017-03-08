package com.iag.exception.ex;

import com.iag.enums.exception.ExceptionEnum;
import org.springframework.validation.BindingResult;

/**
 * Created by beishan on 2017/3/8.
 */
public class RequestParamException extends BusinessException {
    private BindingResult bindingResult;
    public RequestParamException(){

    }

    public RequestParamException(ExceptionEnum ee, BindingResult bindingResult){
        super(ee);
        this.bindingResult = bindingResult;
    }
}
