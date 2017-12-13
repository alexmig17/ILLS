package com.ills.service;


import com.ills.dao.Dao;
import com.ills.entities.View;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ViewService {

    @Autowired
    private Dao<View, String> viewDAO;

    @Transactional
    public View getViewById(String id){
        Criteria criteria = viewDAO.getCriteria();
        criteria.add(Restrictions.eq(View.COL_ID, id));
        return (View) criteria.uniqueResult();
    }
}
