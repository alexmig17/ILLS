package com.ills.entities;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Alex on 28.11.2017.
 */
@Entity
@Table(name = "STUDENT_ENROLLMENT")
public class StudentEnrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "STD_ENR_OID")
    private long oid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STD_ENR_STD_OID", nullable = false)
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STD_ENR_SCH_OID")
    private School school;

    @Temporal(TemporalType.DATE)
    @Column(name = "STD_ENR_START_DATE")
    private Date startDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "STD_ENR_END_DATE")
    private Date endDate;


}
