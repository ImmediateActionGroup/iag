package com.iag.validate.commons;

/**
 * Created by beishan on 2017/4/8.
 */
public class PageQuery {
    private Integer offset;
    private Integer limit;

    public PageQuery(){
        this.offset = 1;
        this.limit = 10;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
