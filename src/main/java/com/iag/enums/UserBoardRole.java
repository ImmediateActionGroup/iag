package com.iag.enums;

import com.iag.exception.enums.ExceptionEnum;
import com.iag.exception.ex.BusinessException;

/**
 * Created by beishan on 2017/3/22.
 */
public enum UserBoardRole {
    //版主
    WEBMASTER(0),
    //副版主
    VICE_WEBMASTER(1),
    ;
    int value;
    UserBoardRole(int value) {
        this.value = value;
    }

    public int value(){
        return value;
    }

    public static UserBoardRole getUBR(int value) throws BusinessException{
        switch (value){
            case 0: return WEBMASTER;
            case 1: return VICE_WEBMASTER;
            default:
                throw new BusinessException(ExceptionEnum.BOARD_USER_ROLE_NOTEXIST);
        }
    }
}
