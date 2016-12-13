package com.iag.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by xueshan.wei on 12/13/2016.
 */
@Entity
@Table(name = "iag_user_role")
public class IagUserRole {
    private Integer id;
    private IagUser user;
    private IagRole role;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public IagUser getUser() {
        return user;
    }

    public void setUser(IagUser user) {
        this.user = user;
    }

    public IagRole getRole() {
        return role;
    }

    public void setRole(IagRole role) {
        this.role = role;
    }
}
