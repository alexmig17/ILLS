package com.ills.dao;

import com.ills.dao.Exceptions.DaoException;
import org.hibernate.Criteria;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * DAO - data access Object
 * Interface provide CRUT operations
 * and method for working with statements, criteria and query
 * CRUT - create, read, update, delete.
 * Created by Alex on 23.11.2017.
 */
public interface Dao <E, K extends Serializable>{

    /**
     * method return all available entities
     * @return
     * @throws DaoException
     */
    Optional<List<E>> getAll() throws DaoException;

    /**
     * method return entity by id
     * @param id
     * @return
     * @throws DaoException
     */
    Optional<E> getByID(K id) throws DaoException;

    /**
     *
     * @param entity
     */
    void update(E entity);


    /**
     *
     * @param entity
     * @return
     */
    Optional<E> merge(E entity);

    /**

     * @param entity
     * @throws DaoException
     */
    void addOrUpdate(E entity) throws DaoException;

    /**
     * delete existing entity
     * @param entity
     * @return true if entity was deleted
     * @throws DaoException
     */
    boolean delete(E entity) throws DaoException;


    /**
     * try add new entity
     * if entity has id - throws DaoException
     * @param entity
     * @return validation errors. If errors exist - operation should fail
     * @throws DaoException
     */
    K add(E entity) throws DaoException;


    /**
     * Return created criteria
     *
     * @throws DaoException
     */
    Criteria getCriteria() throws DaoException;

    /**
     *
     * @return class for current entity
     */
    Class<E> getEntityClass();
}
