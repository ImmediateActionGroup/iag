package com.iag.api.model;

import com.google.gson.annotations.Expose;
import com.iag.model.IagBoard;

/**
 * Created by beishan on 2017/4/8.
 */
public class ApiBoard {
    @Expose
    private Integer id;
    @Expose
    private String name;
    @Expose
    private String icon;
    @Expose
    private String desc;

    public ApiBoard (){

    }
    public ApiBoard (IagBoard board){
        if(board != null){
            this.id = board.getId();
            this.name = board.getBoardName();
            this.icon = board.getIcon();
            this.desc = board.getDescription();
        }
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
