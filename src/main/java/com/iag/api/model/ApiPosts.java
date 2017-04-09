package com.iag.api.model;

import com.google.gson.annotations.Expose;
import com.iag.api.model.user.ApiUser;
import com.iag.model.IagPosts;

/**
 * Created by beishan on 2017/4/8.
 */
public class ApiPosts {
    @Expose
    private Integer id;
    @Expose
    private String title;
    @Expose
    private String content;
    @Expose
    private long pubtime;
    @Expose
    private Integer editType;
    @Expose
    private Integer praise;
    @Expose
    private Integer view;
    @Expose
    private ApiUser user;
    @Expose
    private ApiBoard board;

    public ApiPosts (){

    }

    public ApiPosts (IagPosts posts){
        if(posts != null){
            this.id = posts.getId();
            this.title = posts.getTitle();
            this.content = posts.getContent();
            if(posts.getPublishTime() != null){
                this.pubtime = posts.getPublishTime().getTime();
            }
            this.editType = posts.getEditType();
            this.praise = posts.getPraiseNum();
            this.view = posts.getViewNum();
            this.user = new ApiUser(posts.getUser());
            this.board = new ApiBoard(posts.getBoard());
        }
    }
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

    public long getPubtime() {
        return pubtime;
    }

    public void setPubtime(long pubtime) {
        this.pubtime = pubtime;
    }

    public Integer getEditType() {
        return editType;
    }

    public void setEditType(Integer editType) {
        this.editType = editType;
    }

    public Integer getPraise() {
        return praise;
    }

    public void setPraise(Integer praise) {
        this.praise = praise;
    }

    public Integer getView() {
        return view;
    }

    public void setView(Integer view) {
        this.view = view;
    }

    public ApiUser getUser() {
        return user;
    }

    public void setUser(ApiUser user) {
        this.user = user;
    }

    public ApiBoard getBoard() {
        return board;
    }

    public void setBoard(ApiBoard board) {
        this.board = board;
    }
}
