package com.iag.enums.log;

/**
 * Created by beishan on 2017/3/19.
 */
public enum SystemLog {
    DEFAULT("00000000", "the default log");

    private String code;
    private String msg;

    SystemLog(String code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
