package com.ills.entities;


import javax.persistence.*;

/**
 * Created by Alex on 21.11.2017.
 */
@Entity
@Table(name = "USER")
public class User2 {

    @Id
    /*@GeneratedValue(strategy = GenerationType.IDENTITY )*/
    private String id;
    private String login;
    private String password;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
