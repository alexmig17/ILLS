package com.ills.entities;

import javax.persistence.*;

/**
 * Created by Alex on 02.12.2017.
 */
@Entity
@DiscriminatorValue("EXCLUDE")
@Table(name = "USER_PERMISSION")
public class UserExcludePermission extends UserPermission{

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USR_PRM_USR_OID", nullable = false)
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
