package com.iag.exception.ex;


import com.iag.exception.enums.ExceptionEnum;

/**
 * user login eg.
 * Created by xueshan.wei on 11/14/2016.
 */
public class AuthenticationException extends BusinessException {
    public AuthenticationException() {
    }

    public AuthenticationException(ExceptionEnum ee) {
        super(ee);
    }
}
