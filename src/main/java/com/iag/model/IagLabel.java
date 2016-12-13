package com.iag.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by xueshan.wei on 12/13/2016.
 */
@Entity
@Table(name = "iag_label")
public class IagLabel {
    private Integer id;
    private String labelName;
    private IagUser user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    public IagUser getUser() {
        return user;
    }

    public void setUser(IagUser user) {
        this.user = user;
    }
}
