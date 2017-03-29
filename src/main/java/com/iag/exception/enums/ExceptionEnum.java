package com.iag.exception.enums;

/**
 * Created by beishan on 2017/3/8.
 */
public enum ExceptionEnum {
    NORMAL_EXCETPION("00000000", "默认异常信息"),

    // 用户相关

    //添加用户
    USER_ADD_EXIST_EMAIL("10000001", "用户邮箱已存在"),
    USER_ADD_EXIST_NICKNAME("10000002", "用户昵称已存在"),
    USER_ADD_EXIST_PHONENUM("10000003", "用户手机已存在"),

    USER_NOT_EXIST("10020001", "用户不存在"),

    USER_LOGIN_FAIL("10030001", "用户登录失败"),
    USER_LOGIN_PWD_ERROR("10030002", "用户密码错误"),

    //帖子相关

    POST_EDIT_TYPE_NOTEXIST("40000001", "帖子文本类型不存在"),
    POST_NOT_EXIST("40010001", "帖子不存在"),
    //回复相关
    COMM_ADD_PARENT_NOTEXIST("40060001", "父回复不存在"),
    //角色相关
    ROLE_NOT_EXIST("50000001", "角色不存在"),

    //小黑屋相关
    DARKROOM_NOT_EXIST("60000001", "该用户不在小黑屋，或者已经从小黑屋释放了"),

    //板块相关
    BOARD_USER_ROLE_NOTEXIST("70000001", "版块用户角色不存在"),
    //数据库相关
    DB_CONNECTION_ERROR("80000000", "数据库连接异常"),
    DB_QUERY_ERROR("80000001", "数据库查询异常"),
    DB_UPDATE_ERROR("80000001", "数据库更新异常"),
    DB_DELETE_ERROR("80000001", "数据库删除异常"),
    DB_ADD_ERROR("80000001", "数据库插入异常"),

    MODEL_EXIST("80090001", "要保存的实体已经存在"),

    //数据验证异常
    PARAM_ERROR("90000000", "参数错误");
    //异常代码
    private String code;
    //异常信息
    private String msg;

    ExceptionEnum(String code, String msg){
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
