package com.iag.model;

import javax.persistence.*;

/**
 * Created by xueshan.wei on 12/13/2016.
 */
@Entity
@Table(name = "iag_resource")
public class IagResource {
    private Integer id;
    private String resourceName; // 资源名称
    private String resourceValue; //资源字符串
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @Column(name = "resource_name", nullable = false)
    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    @Column(name = "resource_value", nullable = false)
    public String getResourceValue() {
        return resourceValue;
    }

    public void setResourceValue(String resourceValue) {
        this.resourceValue = resourceValue;
    }
}
