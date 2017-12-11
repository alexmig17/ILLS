package com.ills.entities;

import java.util.List;
import javax.persistence.*;

/**
 * Created by Alex on 28.11.2017.
 */
@Entity
@Table(name = "STUDENT")
public class Student extends EntityA<Long>{

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

    @Override
    public Long getOid() {
        return oid;
    }

    @Override
    public void setOid(Long oid) {
        this.oid = oid;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public List<StudentEnrollment> getStudentEnrollments() {
        return studentEnrollments;
    }

    public void setStudentEnrollments(List<StudentEnrollment> studentEnrollments) {
        this.studentEnrollments = studentEnrollments;
    }
}
