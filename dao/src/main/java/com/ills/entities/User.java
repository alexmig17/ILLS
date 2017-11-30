package com.ills.entities;


import javax.persistence.*;

/**
 * Created by Alex on 21.11.2017.
 */
@Entity
@Table(name = "USER")
public class User implements EntityI {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USR_OID")
    private Long oid;
    private String login;
    private String password;


    public Long getId() {
        return oid;
    }

    public void setId(Long oid) {
        this.oid = oid;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
