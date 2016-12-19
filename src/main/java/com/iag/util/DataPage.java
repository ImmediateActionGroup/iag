package com.iag.util;

import java.util.List;

/**
 * Created by beishan on 2016/11/12.
 */
public class DataPage<T> {
    private int rows;
    private int offset;
    private int limit;
    private List<T> data;
    public void setOffsetLimit(int offset, int limit){
        this.offset = offset;
        this.limit = limit;
    }
    public int start(){
        return offset > 0 ? (offset - 1) * limit : 0;
    }
    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
