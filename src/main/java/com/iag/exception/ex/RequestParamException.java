package com.iag.exception.ex;
import com.iag.exception.enums.ExceptionEnum;
import org.springframework.validation.BindingResult;

/**
 * Created by beishan on 2017/3/8.
 */
public class RequestParamException extends BadRequestException {
    private BindingResult bindingResult;
    public RequestParamException(){

    }

    public RequestParamException(ExceptionEnum ee, BindingResult bindingResult){
        super(ee);
        this.bindingResult = bindingResult;
    }
}
