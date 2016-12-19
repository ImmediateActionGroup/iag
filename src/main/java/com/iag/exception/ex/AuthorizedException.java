package com.iag.exception.ex;

import com.iag.exception.enums.ExceptionEnum;

/**
 * user`s power eg.
 * Created by xueshan.wei on 11/14/2016.
 */
public class AuthorizedException extends BusinessException{
    public AuthorizedException() {
    }

    public AuthorizedException(ExceptionEnum ee) {
        super(ee);
    }
}
