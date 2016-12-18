package com.iag.model;

import javax.persistence.*;

/**
 * Created by xueshan.wei on 12/13/2016.
 */
@Entity
@Table(name = "iag_user_board")
public class IagUserBoard {
    private Integer id;
    private IagUser user; //板块中的用户
    private IagBoard board; //版块
    private Integer roleValue;//用户在版块中的角色
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
    @JoinColumn(name = "board_id")
    public IagBoard getBoard() {
        return board;
    }

    public void setBoard(IagBoard board) {
        this.board = board;
    }
    @Column(name = "role_value", nullable = false)
    public Integer getRoleValue() {
        return roleValue;
    }

    public void setRoleValue(Integer roleValue) {
        this.roleValue = roleValue;
    }
}
