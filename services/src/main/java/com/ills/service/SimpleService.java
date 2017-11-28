package com.ills.service;

import com.ills.dao.Dao;
import com.ills.dto.PersonDTO;
import com.ills.entities.User2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class SimpleService {

    @Autowired
    private Dao<User2, String> userDAO;

    @Transactional
    public PersonDTO getAnyPerson(){
        List list = userDAO.getAll().orElseGet(() -> new ArrayList<>());

        return new PersonDTO();
    }

}
