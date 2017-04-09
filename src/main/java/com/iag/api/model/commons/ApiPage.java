package com.iag.api.model.commons;

import com.google.gson.annotations.Expose;
import com.iag.util.db.DataPage;

/**
 * Created by beishan on 2017/4/8.
 */
public class ApiPage {
    @Expose
    private Integer limit;
    @Expose
    private Integer offset;
    @Expose
    private Integer total;
    @Expose
    private Object data;

    public ApiPage (){

    }
    public ApiPage (DataPage page){
        if(page != null){
            this.limit = page.getLimit();
            this.offset = page.getOffset();
            this.data = page.getData();
            this.total = page.getRows();
        }
    }

    public ApiPage(Integer limit, Integer offset, Integer total, Object data) {
        this.limit = limit;
        this.offset = offset;
        this.total = total;
        this.data = data;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
