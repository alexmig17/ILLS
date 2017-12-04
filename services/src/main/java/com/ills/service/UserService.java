package com.ills.service;

import com.ills.dao.Dao;
import com.ills.dto.PersonDTO;
import com.ills.entities.Person;
import com.ills.entities.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Alex on 28.11.2017.
 */
@Service
public class UserService {

    @Autowired
    private Dao<User, String> userDAO;

    @Transactional
    public List<User> getAllUsers(){
        List<User> list = userDAO.getAll().orElseGet(() -> new ArrayList<>());

        return list;
    }

    @Transactional
    public User getUserByLogin(String login){
        Criteria criteria = userDAO.getCriteria();
        criteria.add(Restrictions.eq("login", login));
        return (User)criteria.uniqueResult();
    }

}
