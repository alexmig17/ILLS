package com.ills.entities;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Alex on 28.11.2017.
 */
@Entity
@Table(name = "STUDENT_ENROLLMENT")
public class StudentEnrollment extends EntityA<Long>{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "STD_ENR_OID")
    private Long oid;

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

    @Override
    public Long getOid() {
        return oid;
    }

    @Override
    public void setOid(Long oid) {
        this.oid = oid;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
