package com.iag.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * board class
 * Created by xueshan.wei on 12/13/2016.
 */
@Entity
@Table(name = "iag_board")
public class IagBoard {
    private Integer id;
    private String boardName;
    private String icon;
    private String description;
    private Integer isDelete;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBoardName() {
        return boardName;
    }

    public void setBoardName(String boardName) {
        this.boardName = boardName;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}
