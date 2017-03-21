package com.iag.enums;

/**
 * Created by beishan on 2017/3/21.
 */
public enum DarkroomStatus {
    //被关押
    IN_ROOM(0),

    //释放
    OUT_ROOM(1)
    ;
    int value;
    DarkroomStatus(int value){
        this.value = value;
    }
    public int value(){
        return value;
    }
}
