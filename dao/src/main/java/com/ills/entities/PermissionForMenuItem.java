package com.ills.entities;

import javax.persistence.*;

@Entity
@DiscriminatorColumn(name = "MENU_ITEM", discriminatorType = DiscriminatorType.STRING)
@Table(name = "PERMISSION")
public class PermissionForMenuItem extends Permission{

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRM_MNI_OID", nullable = true)
    private MenuItem item;

    public MenuItem getItem() {
        return item;
    }

    public void setItem(MenuItem item) {
        this.item = item;
    }
}
