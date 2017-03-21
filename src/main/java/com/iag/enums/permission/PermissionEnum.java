package com.iag.enums.permission;

/**
 * 资源操作权限枚举类
 * 包括增删查改四种基本操作权限
 * add, delete, query, update
 * Created by xueshan.wei on 3/21/2017.
 */
public enum PermissionEnum {
    ADD("add"),
    DELETE("delete"),
    QUERY("query"),
    UPDATE("update")
    ;
    String value;
    PermissionEnum(String value){
        this.value = value;
    }

    public String value(){
        return value;
    }
}
