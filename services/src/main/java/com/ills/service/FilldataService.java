package com.ills.service;


import com.ills.dao.Dao;
import com.ills.entities.Person;
import com.ills.entities.User2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Service
public class FilldataService {

    @Autowired
    private Dao<User2, String> userDAO;

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
        User2 user2 = new User2();
        user2.setLogin("admin");
        user2.setPassword("admin");
        userDAO.add(user2);
    }

}
