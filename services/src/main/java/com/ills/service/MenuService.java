package com.ills.service;

import com.ills.dao.Dao;
import com.ills.dto.MenuDTO;
import com.ills.entities.Menu;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class MenuService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    Dao<Menu, Integer> menuDAO;

    @Transactional
    public MenuDTO getFullMenuByName(String menuName){

        Criteria criteria = menuDAO.getCriteria();
        criteria.add(Restrictions.eq(Menu.COL_NAME, menuName));
        Menu menu = (Menu)criteria.uniqueResult();
        MenuDTO menuDto = modelMapper.map(menu, MenuDTO.class);

        return menuDto;
    }
}
