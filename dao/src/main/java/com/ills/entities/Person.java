package com.ills.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import java.util.Date;

@Entity
@Table(name = "PERSON")
public class Person {

    @Id
    @Column(name = "ID")
    @GenericGenerator(name = "entity_id", strategy = "com.ills.generator.keys.EntityKeyGenerator", parameters = {
            @org.hibernate.annotations.Parameter(
                    name = "sequence_name", value = "hibernate_sequence"),
            @org.hibernate.annotations.Parameter(
                    name = "sequence_prefix", value = "CTC_"),
    })
    @GeneratedValue(generator = "entity_id" )
    private String id;
    private String firstName;
    private String lastName;
    private Date dob;
    /*private User user;*/
    private String homePhone;


    public String getId() {
        return id;
    }

    public void setId(String id) {
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
