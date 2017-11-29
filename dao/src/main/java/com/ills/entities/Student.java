package com.ills.entities;

import java.util.List;
import javax.persistence.*;

/**
 * Created by Alex on 28.11.2017.
 */
@Entity
@Table(name = "STUDENT")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="STD_OID", length = 14)
    private Long oid;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "STD_PSN_OID")
    private Person person;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "STD_SCH_OID")
    private School school;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "student")
    private List<StudentEnrollment> studentEnrollments;

}
