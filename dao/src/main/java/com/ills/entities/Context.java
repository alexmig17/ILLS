package com.ills.entities;

import javax.persistence.*;

/**
 * Created by Alex on 10.12.2017.
 */
@Entity
@Table(name = "CONTEXT")
public class Context {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CXT_OID")
    private Long oid;

    private String name;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CXT_PRM_OID")
    private Permission permission;

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }
}
