package com.ills.dao;

import com.ills.dao.Exceptions.DaoException;
import com.ills.entities.ValidationError;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Alex on 23.11.2017.
 */
public class DaoImpl<E, K extends Serializable> implements Dao<E, K> {

    private SessionFactory sessionFactory;
    private Class<E> type;

    //private static Logger log = Logger.getLogger(DaoImpl.class);

    public DaoImpl(Class<E> type) {
        this.type = type;
    }


    @Override
    public List<E> getAll() throws DaoException {
        List<E> list;
        try {
            list = getSession().createCriteria(type).list();
        } catch (HibernateException e) {
            throw new DaoException(e);
        }
        return list;
    }

    @Override
    public E getByID(K id) throws DaoException {
        E entity;
        try {
            entity = (E)getSession().get(type, id);

        } catch (HibernateException e){
            throw new DaoException(e);
        }
        return entity;
    }


    @Override
    public void makePersistent(E entity) throws DaoException {

        try {
            getSession().saveOrUpdate(entity);
        } catch (HibernateException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public boolean delete(E entity) throws DaoException {
        try {
            getSession().delete(entity);
        } catch (HibernateException e) {
            throw new DaoException(e);
        }
        return true;

    }

    @Override
    public K add(E entity) throws DaoException {
        K id;
        try {
            id = (K)getSession().save(entity);

        } catch (HibernateException e) {
            throw new DaoException(e);
        }
        return id;
    }

    @Override
    public Class<E> getEntityClass() {
        return type;
    }

    private Session getSession(){
        return sessionFactory.getCurrentSession();
    }

}
