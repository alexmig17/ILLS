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

    @Column(name = "MNI_NAME", unique = true)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MNI_MNU_OID", nullable = false)
    private Menu menu;

    @Column(name ="MNI_LEVEL")
    private int level;

    @OneToMany(mappedBy="item")
    private List<MenuItem> items;

    @ManyToOne(fetch = FetchType.LAZY, cascade={CascadeType.ALL})
    @JoinColumn(name="MNI_MNI_OID")
    private MenuItem item;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MNI_PRM_OID")
    private Permission permission;

    public long getOid() {
        return oid;
    }

    public void setOid(long oid) {
        this.oid = oid;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public void setItems(List<MenuItem> items) {
        this.items = items;
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }

    public MenuItem getItem() {
        return item;
    }

    public void setItem(MenuItem item) {
        this.item = item;
    }
}
