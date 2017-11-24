package com.ills.dao.Exceptions;

/**
 * Created by Alex on 23.11.2017.
 */
public class DaoException extends RuntimeException {

    public DaoException(Exception e){
        super(e);
    }


}
