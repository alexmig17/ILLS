package com.ills.entities;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "MENU")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MNU_OID")
    private long oid;

    @Column(name = "MNU_NAME")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "menu")
    private List<MenuItem> items;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "MENU_GO_TO", joinColumns = {
            @JoinColumn(name = "MGT_FROM_MNU_OID")},
            inverseJoinColumns = {@JoinColumn(name = "MGT_AVAILABLE_MNU_OID")
    })
    private List<Menu> listMenu;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MNU_PRM_OID")
    private Permission permission;

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

    public List<MenuItem> getItems() {
        return items;
    }

    public void setItems(List<MenuItem> items) {
        this.items = items;
    }

    public List<Menu> getListMenu() {
        return listMenu;
    }

    public void setListMenu(List<Menu> listMenu) {
        this.listMenu = listMenu;
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }


}
