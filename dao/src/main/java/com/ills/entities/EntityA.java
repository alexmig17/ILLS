package com.ills.entities;

import java.io.Serializable;

/**
 * Created by Alex on 08.12.2017.
 */
public abstract class EntityA<K extends Serializable> implements EntityI<K> {

    @Override
    public boolean isNew() {
        return this.getOid() == null;
    }

    @Override
    public int hashCode() {
        return getOid() == null ? 0 : getOid().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        EntityI input = (EntityI) obj;

        return (getOid() == null ? input.getOid() ==null : getOid().equals(input.getOid()));
    }
}
