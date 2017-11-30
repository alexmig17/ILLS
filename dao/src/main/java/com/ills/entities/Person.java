package com.ills.entities;

import io.swagger.annotations.ApiModel;

import javax.persistence.*;

import java.util.Date;

@Entity
@Table(name = "PERSON")
@ApiModel(value = "PERSON")
public class Person implements EntityI {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="PRN_OID", length = 14)
    private Long oid;

    @Column(name="PRN_FIRST_NAME", length = 100)
    private String firstName;

    @Column(name="PRN_LAST_NAME", length = 100)
    /*@Formula("(select PRN_FIRST_NAME from PERSON p where PRN_OID = p.PRN_OID)")*/
    private String lastName;

    @Column(name="PRN_DOB")
    private Date dob;

    /*@Temporal(TemporalType.DATE)
    private Date date;
    @Temporal(TemporalType.TIME)
    private Date time;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTime;*/

    @Column(name="PRN_HOME_PHONE")
    private String homePhone;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="PSN_USR_OID", unique=false, nullable=true)
    private User user;

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
