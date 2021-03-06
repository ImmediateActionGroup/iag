package com.iag.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by xueshan.wei on 12/13/2016.
 */
@Entity
@Table(name = "iag_role")
public class IagRole {
    private Integer id;
    private String roleName; //角色名称
    private Set<IagUser> users = new HashSet<IagUser>();

    private Set<IagResPer> resPers = new HashSet<IagResPer>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @Column(name = "role_name", nullable = false)
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles")
    public Set<IagUser> getUsers() {
        return users;
    }

    public void setUsers(Set<IagUser> users) {
        this.users = users;
    }

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JoinTable(name = "iag_role_resper", joinColumns = {@JoinColumn(name = "role_id")},
        inverseJoinColumns = {@JoinColumn(name = "res_per_id")})
    public Set<IagResPer> getResPers() {
        return resPers;
    }

    public void setResPers(Set<IagResPer> resPers) {
        this.resPers = resPers;
    }
}
