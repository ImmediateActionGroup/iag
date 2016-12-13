package com.iag.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by xueshan.wei on 12/13/2016.
 */
@Entity
@Table(name = "iag_permission")
public class IagPermission {
    private Integer id;
    private String permissionName;
}
