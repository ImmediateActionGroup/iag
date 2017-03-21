package com.iag.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by xueshan.wei on 12/13/2016.
 */
@Entity
@Table(name = "iag_resource_permission")
public class IagResPer {
    private Integer id;
    private IagResource resource; //资源
    private IagPermission permission; //权限
    private String resPerValue; // 资源权限字符串

    private Set<IagRole> roles = new HashSet<IagRole>();
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
    @JoinColumn(name = "resource_id")
    public IagResource getResource() {
        return resource;
    }

    public void setResource(IagResource resource) {
        this.resource = resource;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "permission_id")
    public IagPermission getPermission() {
        return permission;
    }

    public void setPermission(IagPermission permission) {
        this.permission = permission;
    }

    @Column(name = "res_per_value")
    public String getResPerValue() {
        return resPerValue;
    }

    public void setResPerValue(String resPerValue) {
        this.resPerValue = resPerValue;
    }

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "resPers")
    public Set<IagRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<IagRole> roles) {
        this.roles = roles;
    }
}
