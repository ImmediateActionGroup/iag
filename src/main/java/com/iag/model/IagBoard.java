package com.iag.model;

import javax.persistence.*;

/**
 * board class
 * Created by xueshan.wei on 12/13/2016.
 */
@Entity
@Table(name = "iag_board")
public class IagBoard {
    private Integer id; //主键
    private String boardName; //板块名称
    private String icon; //板块图标logo
    private String description; //板块描述
    private Integer isDelete; //标记是否删除，软删除

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "board_name", nullable = false)
    public String getBoardName() {
        return boardName;
    }

    public void setBoardName(String boardName) {
        this.boardName = boardName;
    }

    @Column(name = "icon", nullable = false)
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "is_delete")
    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}
