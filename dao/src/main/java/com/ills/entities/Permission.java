package com.ills.entities;

import javax.persistence.*;

/**
 * Created by Alex on 02.12.2017.
 */
@Entity
@Table(name = "PERMISSION")
public class Permission extends EntityA<Long>{

    public enum PermissionType{
        ROLE, MENU, MENU_ITEM
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PRM_OID")
    private Long oid;

    @Column(name = "PRM_NAME")
    private String name;


    @Column(name = "PRM_TYPE")
    @Enumerated(EnumType.STRING)
    private PermissionType type;

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

    public PermissionType getType() {
        return type;
    }

    public void setType(PermissionType type) {
        this.type = type;
    }
}
