package com.ills.entities;

import java.lang.Long;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "MENU")
public class Menu extends EntityA<Long>{

    public static final String COL_OID = "oid";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MNU_OID")
    private Long oid;

    @Column(name = "MNU_NAME", unique = true)
    private String name;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "menu")
    private List<MenuItem> items;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "MENU_GO_TO", joinColumns = {
            @JoinColumn(name = "MGT_FROM_MNU_OID")},
            inverseJoinColumns = {@JoinColumn(name = "MGT_AVAILABLE_MNU_OID")
    })
    private List<Menu> listMenu;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "MNU_CXT_OID", nullable = false, unique = true)
    private Context context;

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
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

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
