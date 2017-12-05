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

    /*@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable( name = "MENU_MENU", joinColumns = { @JoinColumn(name = "employee_id") },
                    inverseJoinColumns = { @JoinColumn(name = "project_id") }
                )
    private List<Menu> listMenu;*/

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MNU_PRM_OID")
    private Permission permission;







}
