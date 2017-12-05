package com.ills.entities;

import javax.persistence.*;

/**
 * Created by Alex on 02.12.2017.
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "PRM_TYPE")
@Table(name = "PERMISSION")
abstract public class Permission {

    public enum PermissionType{
        ROLE, MENU, MENU_ITEM
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PRM_OID")
    private long oid;

    @Column(name = "PRM_NAME")
    private String name;


    @Column(name = "PRM_TYPE")
    private PermissionType type;

    public long getOid() {
        return oid;
    }

    public void setOid(long oid) {
        this.oid = oid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
