package com.ills.service;


import com.ills.dao.Dao;
import com.ills.entities.Person;
import com.ills.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Service
public class FilldataService {

    @Autowired
    private Dao<User, String> userDAO;

    @Autowired
    private Dao<Person, String> personDAO;

    @Transactional
    public void fillPerson(){
        Person person = new Person();
        person.setFirstName("Alexey");
        person.setLastName("Drapun");
        ZoneId defaultZoneId = ZoneId.systemDefault();
        Date date = Date.from(LocalDate.parse("1988-09-17").atStartOfDay(defaultZoneId).toInstant());
        person.setDob(date);
        personDAO.add(person);


    }

    @Transactional
    public void fillUser(){
        User user = new User();
        user.setLogin("admin");
        user.setPassword("admin");
        userDAO.add(user);
    }

}
