package com.ills.entities;

import java.io.Serializable;

/**
 * Created by Alex on 08.12.2017.
 */
public interface EntityI<K extends Serializable> extends Serializable{

    void setOid(K id);
    K getOid();
    boolean isNew();

}
