package com.ills.entities;

import javax.persistence.*;
import java.util.List;

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

    @Column(name = "CXT_NAME")
    private String name;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CXT_PRM_OID")
    private Permission permission;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "contexts")
    private List<View> viewList;

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

    public List<View> getViewList() {
        return viewList;
    }

    public void setViewList(List<View> viewList) {
        this.viewList = viewList;
    }
}
