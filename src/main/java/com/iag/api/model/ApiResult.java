package com.iag.api.model;

import com.google.gson.annotations.Expose;
import org.springframework.stereotype.Component;

/**
 * API返回结果的实体类, 用于承载API的结果
 * Created by beishan on 2017/3/8.
 */
@Component
public class ApiResult {
    //API返回的代码，00000000为默认代码，表示API调用正常
    @Expose
    private String code;
    //API调用返回的信息，默认信息为”查询正常“
    @Expose
    private String msg;
    //API调用返回的实体数据，可能是map 也可能是list
    @Expose
    private Object data;

    public ApiResult(){
        this.code = "00000000";
        this.msg = "查询正常";
        this.data = null;
    }

    /**
     * 设置 api 返回的信息，以及返回的内容
     * @param msg
     * @param data
     */
    public void setApiResult(String msg, Object data){
        this.msg = msg;
        this.data = data;
    }
    public void reset(){
        this.code = "00000000";
        this.msg = "查询正常";
        this.data = null;
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
