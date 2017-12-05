package com.ills.entities;


import javax.persistence.*;

@Entity
@DiscriminatorColumn(name = "MENU", discriminatorType = DiscriminatorType.STRING)
public class PermissionForMenu extends  Permission{

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRM_MNU_OID", nullable = true)
    private Menu menu;

}
