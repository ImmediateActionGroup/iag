package com.iag.model;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.*;

/**
 * user entity @author beishan
 * Created by xueshan.wei on 12/13/2016.
 */
@Entity
@Table(name = "iag_user")
public class IagUser {
    private Integer id; //主键
    private String username; //用户名
    private String nickname; //昵称
    private String email; //邮箱
    private String password; //密码
    private String phoneNum; //手机号码
    private Integer isDelete; //标记是否删除，软删除
    private Date registerTime; //注册时间
    private Date lastModifyTime; //最后修改个人资料时间
    private Date lastLoginTime; //最后登录时间
    //关注的人
    private Set<IagUser> attentions = new HashSet<IagUser>();
    //被谁关注
    private Set<IagUser> attentioneds = new HashSet<IagUser>();
    //发表的回复
    private List<IagComments> commentss = new ArrayList<IagComments>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "username", nullable = false)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "nickname")
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Column(name = "email", nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Column(name = "phone_num")
    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
    @Column(name = "is_delete", nullable = false)
    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
    @Column(name = "register_time", nullable = false)
    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }
    @Column(name = "last_modify_time", nullable = false)
    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }
    @Column(name = "last_login_time", nullable = false)
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "attention")
    public Set<IagUser> getAttentions() {
        return attentions;
    }

    public void setAttentions(Set<IagUser> attentions) {
        this.attentions = attentions;
    }
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "attentioned")
    public Set<IagUser> getAttentioneds() {
        return attentioneds;
    }

    public void setAttentioneds(Set<IagUser> attentioneds) {
        this.attentioneds = attentioneds;
    }
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
    public List<IagComments> getCommentss() {
        return commentss;
    }

    public void setCommentss(List<IagComments> commentss) {
        this.commentss = commentss;
    }
}
