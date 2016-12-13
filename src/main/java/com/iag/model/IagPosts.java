package com.iag.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by xueshan.wei on 12/13/2016.
 */
@Entity
@Table(name = "iag_posts")
public class IagPosts {
    private Integer id;
    private String title;
    private String content;
    private Date publishTime;
    private Integer viewNum;
    private Integer praiseNum;
    private Integer editType;
    private Integer isDelete;
    private Integer isHidden;
    private Date lastModifyTime;
    private IagUser user;
    private IagBoard board;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Integer getViewNum() {
        return viewNum;
    }

    public void setViewNum(Integer viewNum) {
        this.viewNum = viewNum;
    }

    public Integer getPraiseNum() {
        return praiseNum;
    }

    public void setPraiseNum(Integer praiseNum) {
        this.praiseNum = praiseNum;
    }

    public Integer getEditType() {
        return editType;
    }

    public void setEditType(Integer editType) {
        this.editType = editType;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getIsHidden() {
        return isHidden;
    }

    public void setIsHidden(Integer isHidden) {
        this.isHidden = isHidden;
    }

    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    public IagUser getUser() {
        return user;
    }

    public void setUser(IagUser user) {
        this.user = user;
    }

    public IagBoard getBoard() {
        return board;
    }

    public void setBoard(IagBoard board) {
        this.board = board;
    }
}
