package com.ills.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import java.util.Date;

@Entity
@Table(name = "PERSON")
public class Person {

    @Id
    @GeneratedValue(generator = "AppSeqStore", strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;
    private Date dob;

    private String homePhone;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }


    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }
}
