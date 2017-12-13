package com.ills.service;

import com.ills.dao.Dao;
import com.ills.entities.Context;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContextService {

    @Autowired
    private Dao<Context, String> contextDAO;

    @Transactional
    public Context getContextByName(String contextName){
        Criteria criteria = contextDAO.getCriteria();
        criteria.add(Restrictions.eq(Context.COL_NAME, contextName));
        return (Context) criteria.uniqueResult();
    }

}
