package com.ills.entities;

import com.sun.javafx.beans.IDProperty;

import javax.persistence.*;

/**
 * Created by Alex on 02.12.2017.
 */
@Entity
@Table(name = "ROLE_PERMISSION")
public class RolePermission extends EntityA<Long>{

    @Id
    @Column(name = "ROL_PRM_OID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long oid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ROL_PRM_ROL_OID")
    private Role role;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "ROL_PRM_PRM_OID")
    private Permission permission;

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }
}
