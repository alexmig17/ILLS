package com.ills.entities;

import javax.persistence.*;

/**
 * Created by Alex on 02.12.2017.
 */
@Entity
@Table(name = "USER_ROLE")
public class UserRole extends EntityA<Long>{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USR_ROL_OID")
    private Long oid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USR_ROL_USR_OID", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "USR_ROL_ROL_OID", nullable = false)
    private Role role;

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
