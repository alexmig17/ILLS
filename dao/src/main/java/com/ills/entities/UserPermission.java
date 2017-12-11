package com.ills.entities;

import javax.persistence.*;

/**
 * Created by Alex on 02.12.2017.
 */

@Entity(name = "userPermission")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "USER_PERMISSION")
@DiscriminatorColumn(name = "USR_PRM_TYPE", discriminatorType = DiscriminatorType.STRING)
public class UserPermission extends EntityA<Long>
{


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USR_PRM_OID")
    private Long oid;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USR_PRM_PRM_OID", nullable = false)
    private Permission permission;

    @Override
    public Long getOid() {
        return oid;
    }

    @Override
    public void setOid(Long oid) {
        this.oid = oid;
    }
}
