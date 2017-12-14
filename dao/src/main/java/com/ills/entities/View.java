package com.ills.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Alex on 10.12.2017.
 */
@Entity
@Table(name = "VIEW")
public class View {

    public static final String COL_ID = "id";

    @Id
    @Column(name = "VEW_OID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long oid;

    @Column(name = "VEW_NAME")
    private String name;

    @Column(name = "VEW_URI")
    private String uri;

    @Column(name = "VEW_ID", nullable = false, unique = true)
    private String id;

    //private String type; // memo + uri,

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "VIEW_BASED_BEAN",
            joinColumns = { @JoinColumn(name = "VBB_VEW_OID") },
            inverseJoinColumns = { @JoinColumn(name = "VBB_BSB_OID") }
    )
    private List<BasedBean> basedBeans;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "VIEW_CONTEXT",
            joinColumns = { @JoinColumn(name = "VCT_VEW_OID") },
            inverseJoinColumns = { @JoinColumn(name = "VCT_CXT_OID") }
    )
    private List<Context> contexts;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "VEW_PRM_OID")
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

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public List<Context> getContexts() {
        return contexts;
    }

    public void setContexts(List<Context> contexts) {
        this.contexts = contexts;
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
