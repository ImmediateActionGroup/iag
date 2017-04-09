package com.iag.exception.ex.api;

import com.iag.exception.enums.ExceptionEnum;
import com.iag.exception.ex.ApiBusinessException;
import org.springframework.validation.BindingResult;

/**
 * Created by beishan on 2017/4/8.
 */
public class ApiParamException extends ApiBusinessException {
    private BindingResult bindingResult;

    public BindingResult getBindingResult() {
        return bindingResult;
    }

    public ApiParamException(ExceptionEnum ee, BindingResult bindingResult){
        super(ee);
        this.bindingResult = bindingResult;
    }
}
