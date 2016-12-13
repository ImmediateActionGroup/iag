package com.iag.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by xueshan.wei on 12/13/2016.
 */
@Entity
@Table(name = "iag_user_board")
public class IagUserBoard {
    private Integer id;
    private IagUser user;
    private IagBoard board;
    private Integer roleValue;

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

    public IagBoard getBoard() {
        return board;
    }

    public void setBoard(IagBoard board) {
        this.board = board;
    }

    public Integer getRoleValue() {
        return roleValue;
    }

    public void setRoleValue(Integer roleValue) {
        this.roleValue = roleValue;
    }
}
