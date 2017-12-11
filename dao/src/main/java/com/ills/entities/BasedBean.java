package com.ills.entities;

import javax.persistence.*;

/**
 * Created by Alex on 10.12.2017.
 */

@Entity
@Table(name = "BASED_BEAN")
public class BasedBean extends EntityA<Long>{

    @Id
    @Column(name = "BSB_OID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long oid;

    @Column(name = "BSB_NAME")
    private String name;

    @Override
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
}
