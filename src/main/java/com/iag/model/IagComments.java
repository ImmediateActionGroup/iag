package com.iag.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by xueshan.wei on 12/13/2016.
 */
@Entity
@Table(name = "iag_comments")
public class IagComments {
    private Integer id; //主键
    private String content; //内容
    private Date publishTime; //发布时间
    private Integer praiseNum; //点赞数
    private Integer badNum; //反对数
    private IagUser user; //发表人
    private IagPosts posts; //所属帖子
    private IagComments comments; //父回复， 如果没有则id为0


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "content", nullable = false)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    @Column(name = "publish_time", nullable = false)
    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }
    @Column(name = "praise_num", nullable = false)
    public Integer getPraiseNum() {
        return praiseNum;
    }

    public void setPraiseNum(Integer praiseNum) {
        this.praiseNum = praiseNum;
    }
    @Column(name = "bad_num", nullable = false)
    public Integer getBadNum() {
        return badNum;
    }

    public void setBadNum(Integer badNum) {
        this.badNum = badNum;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    public IagUser getUser() {
        return user;
    }

    public void setUser(IagUser user) {
        this.user = user;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "posts_id", nullable = false)
    public IagPosts getPosts() {
        return posts;
    }

    public void setPosts(IagPosts posts) {
        this.posts = posts;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id", nullable = false)
    public IagComments getComments() {
        return comments;
    }

    public void setComments(IagComments comments) {
        this.comments = comments;
    }
}
