package com.ills.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "MENU_ITEM")
public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MNI_OID")
    private long oid;

    @Column(name = "MNI_CONTEXT")
    private String context;

    @Column(name = "MNI_NAME")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MNI_MNU_OID", nullable = false)
    private Menu menu;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "parentItem")
    private List<MenuItem> items;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MNI_MNI_OID")
    private MenuItem parentItem;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MNU_PRM_OID")
    private Permission permission;

    



}
