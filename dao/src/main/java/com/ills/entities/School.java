package com.ills.entities;

import javax.persistence.*;

/**
 * Created by Alex on 28.11.2017.
 */
@Entity
@Table(name = "SCHOOL")
public class School extends EntityA<Long>{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "SCH_OID")
    private Long oid;

    @Column(name = "SCH_SCHOOL_NAME")
    private String schoolName;

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
}
