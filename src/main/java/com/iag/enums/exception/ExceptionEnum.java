package com.iag.enums.exception;

/**
 * Created by beishan on 2017/3/8.
 */
public enum ExceptionEnum {
    NORMAL_EXCETPION("00000000", "默认异常信息"),

    // 用户相关

    //帖子相关

    //恢复相关

    //数据库相关
    DB_CONNECTION_ERROR("80000000", "数据库连接异常"),
    DB_QUERY_ERROR("80000001", "数据库查询异常"),
    DB_UPDATE_ERROR("80000001", "数据库更新异常"),
    DB_DELETE_ERROR("80000001", "数据库删除异常"),
    DB_ADD_ERROR("80000001", "数据库插入异常");
    //异常代码
    private String code;
    //异常信息
    private String msg;

    ExceptionEnum (String code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public String getCode(){
        return this.code;
    }

    public String getMsg() {
        return msg;
    }
}
