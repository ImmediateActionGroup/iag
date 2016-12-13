package com.iag.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by xueshan.wei on 12/13/2016.
 */
@Entity
@Table(name = "iag_resource_permission")
public class IagResPer {
    private Integer id;
    private IagResource resource;
    private IagPermission permission;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public IagResource getResource() {
        return resource;
    }

    public void setResource(IagResource resource) {
        this.resource = resource;
    }

    public IagPermission getPermission() {
        return permission;
    }

    public void setPermission(IagPermission permission) {
        this.permission = permission;
    }
}
