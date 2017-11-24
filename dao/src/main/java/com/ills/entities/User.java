package com.ills.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Alex on 21.11.2017.
 */
@Entity
public class User {
    private String id;

    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
