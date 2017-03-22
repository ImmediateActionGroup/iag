package com.iag.enums;

/**
 * Created by xueshan.wei on 3/22/2017.
 */
public enum ModelIsOrNot {
    IS(1),
    NOT(0)
    ;
    int value;
    ModelIsOrNot(int value){
        this.value = value;
    }

    public int value(){
        return value;
    }
}
