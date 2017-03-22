package com.iag.validate;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * Created by beishan on 2017/3/22.
 */
public class ValidateBoard {
    @NotBlank(message = "版块名称不能为空")
    private String name;

    private String icon;

    private String desc;
    @NotNull(message = "版主id不能为空")
    private Integer uid;
    @NotNull(message = "版主角色不能为空")
    private Integer role;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }
}
