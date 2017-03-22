package com.iag.enums;

import com.iag.exception.enums.ExceptionEnum;
import com.iag.exception.ex.BusinessException;

/**
 * Created by beishan on 2017/3/22.
 */
public enum PostsEditType {
    RICHTEXT(0),
    MARKDOWN(1)
    ;
    int value;
    PostsEditType(int value){
        this.value = value;
    }

    public int value(){
        return value;
    }

    public static PostsEditType getPET(int value) throws BusinessException{
        switch (value){
            case 0: return RICHTEXT;
            case 1: return MARKDOWN;
            default:
                throw new BusinessException(ExceptionEnum.POST_EDIT_TYPE_NOTEXIST);
        }
    }
}
