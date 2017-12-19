package com.ills.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "MENU_ITEM")
public class MenuItem extends EntityA<Long>{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MNI_OID")
    private Long oid;

    @Column(name = "MNI_NAME", unique = true)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MNI_MNU_OID")
    private Menu menu;

    @Column(name ="MNI_LEVEL")
    private int level;

    @OneToMany(mappedBy="item", cascade = CascadeType.ALL)
    private List<MenuItem> items;

    @ManyToOne(fetch = FetchType.LAZY, cascade={CascadeType.ALL})
    @JoinColumn(name="MNI_MNI_OID")
    private MenuItem item;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "MNI_CXT_OID", nullable = false, unique = true)
    private Context context;

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

    public MenuItem getItem() {
        return item;
    }

    public void setItem(MenuItem item) {
        this.item = item;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
