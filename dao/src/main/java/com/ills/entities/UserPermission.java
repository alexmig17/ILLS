package com.ills.entities;

import javax.persistence.*;

/**
 * Created by Alex on 02.12.2017.
 */

@Entity(name = "userPermission")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "USER_PERMISSION")
@DiscriminatorColumn(name = "USR_PRM_TYPE", discriminatorType = DiscriminatorType.STRING)
public class UserPermission
{


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USR_PRM_OID")
    private long oid;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USR_PRM_PRM_OID", nullable = false)
    private Permission permission;






}
