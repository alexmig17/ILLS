package com.ills.service;

import com.ills.dao.Dao;
import com.ills.dto.ContextDTO;
import com.ills.entities.Context;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContextService {

    @Autowired
    private Dao<Context, String> contextDAO;

    @Autowired
    ModelMapper modelMapper;

    @Transactional
    public ContextDTO getContextByName(String contextName){
        Criteria criteria = contextDAO.getCriteria();
        criteria.add(Restrictions.eq(Context.COL_NAME, contextName));
        Context context = (Context) criteria.uniqueResult();
        return modelMapper.map(context, ContextDTO.class);
    }

}
