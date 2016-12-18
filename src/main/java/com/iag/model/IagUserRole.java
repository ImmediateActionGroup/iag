package com.iag.model;

import javax.persistence.*;

/**
 * Created by xueshan.wei on 12/13/2016.
 */
@Entity
@Table(name = "iag_user_role")
public class IagUserRole {
    private Integer id;
    private IagUser user; //用户
    private IagRole role; //角色
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    public IagUser getUser() {
        return user;
    }

    public void setUser(IagUser user) {
        this.user = user;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    public IagRole getRole() {
        return role;
    }

    public void setRole(IagRole role) {
        this.role = role;
    }
}
