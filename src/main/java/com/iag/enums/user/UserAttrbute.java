package com.iag.enums.user;

/**
 * Created by beishan on 2017/4/8.
 */
public enum UserAttrbute {
    CURRENT_USER("currentUser")
    ;
    String value;
    UserAttrbute(String value){
        this.value = value;
    }

    public String value(){
        return value;
    }
}
