package com.iag.enums;

/**
 * 用于规定是否delete字段的值
 * Created by xueshan.wei on 3/21/2017.
 */
public enum ModelIsDelete {
    DELETE(1),
    NOT_DELETE(0)
    ;
    int value;
    ModelIsDelete(int value){
        this.value = value;
    }

    public int value(){
        return value;
    }
}
