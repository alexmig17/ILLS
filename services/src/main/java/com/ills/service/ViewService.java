package com.ills.service;


import com.ills.dao.Dao;
import com.ills.dto.BasedBeanDTO;
import com.ills.dto.Dto;
import com.ills.dto.ViewDTO;
import com.ills.entities.EntityA;
import com.ills.entities.View;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ViewService {


    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private Dao<View, String> viewDAO;

    @Transactional
    public ViewDTO getViewById(String id){
        Criteria criteria = viewDAO.getCriteria();
        criteria.add(Restrictions.eq(View.COL_ID, id));
        View view = (View) criteria.uniqueResult();
        ViewDTO viewDto = modelMapper.map(view, ViewDTO.class);
        return viewDto;
    }

    @Transactional
    public List<Dto> getPaginatedDtoList(BasedBeanDTO basedBean, int start, int maxSize) {
        Class classObj = null;

        try {
            classObj = Class.forName(basedBean.getEntityName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Criteria criteria = viewDAO.getCriteriaByClass(classObj);
        criteria.setFirstResult(start);
        criteria.setMaxResults(maxSize);
        Class<Dto> classDto = null;
        try {
            classDto = (Class<Dto>) Class.forName(basedBean.getDtoName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return  translateEntityIntoDto(criteria.list(), classDto);
    }

    public List<Dto>   translateEntityIntoDto(List<EntityA> entities, Class<Dto> dtoClass) {
        List<Dto> dtoList = new ArrayList<>(entities.size());
        for(EntityA enity: entities){
            Dto dto = null;
            try {
                dto = dtoClass.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            dto = dto.translateEntityIntoDto(enity, dtoClass);
            dtoList.add(dto);
        }
        return dtoList;
    }

}
