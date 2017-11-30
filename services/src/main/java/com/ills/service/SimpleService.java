package com.ills.service;

import com.ills.dao.Dao;
import com.ills.dto.PersonDTO;
import com.ills.entities.Person;
import com.ills.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SimpleService {

    @Autowired
    private Dao<Person, String> personDAO;

    @Transactional
    public List<PersonDTO> getAllPersons(){
        List<Person> list = personDAO.getAll().orElseGet(() -> new ArrayList<>());
        List<PersonDTO> persons = list.stream().map(person -> new PersonDTO(person)).collect(Collectors.toList());
        return persons;
    }

}
