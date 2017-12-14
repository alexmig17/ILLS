package com.ills.dao;

import com.ills.dao.Exceptions.DaoException;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

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
    public Optional<List<E>> getAll() throws DaoException {

        Optional optional;
        try {
            optional = Optional.ofNullable(getSession().createCriteria(type).list());
        } catch (HibernateException e) {
            throw new DaoException(e);
        }

        return optional;
    }

    @Override
    public Optional<E> getByID(K id) throws DaoException {
        E entity;
        try {
            entity = (E)getSession().get(type, id);

        } catch (HibernateException e){
            throw new DaoException(e);
        }
        return Optional.ofNullable(entity);
    }

    /**
     * update detached entity
     * @param entity
     */
    @Override
    public void update(E entity) {
        try {
            getSession().update(entity);
        } catch (HibernateException e) {
            throw new DaoException(e);
        }

    }

    /**
     * update detached entity or add transient entity
     * @param entity detached or transient
     * @throws DaoException
     */
    @Override
    public void addOrUpdate(E entity) throws DaoException {

        try {
            getSession().saveOrUpdate(entity);
        } catch (HibernateException e) {
            throw new DaoException(e);
        }
    }

    /**
     *
     * @param entity detached instance
     * @return merged persistent instance
     */
    @Override
    public Optional<E> merge(E entity) {
        Optional optional;
        try {
            optional = Optional.ofNullable(getSession().merge(entity));
        } catch (HibernateException e) {
            throw new DaoException(e);
        }
        return optional;
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
    public Criteria getCriteria() throws DaoException {
        return getCriteriaByClass(type);
    }

    @Override
    public Criteria getCriteriaByClass(Class clazz) throws DaoException {
        return getSession().createCriteria(clazz);
    }

    @Override
    public Class<E> getEntityClass() {
        return type;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getSession(){
        return sessionFactory.getCurrentSession();
    }

}
