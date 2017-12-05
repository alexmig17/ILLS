package com.ills.service;


import com.ills.dao.Dao;
import com.ills.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

@Service
public class FilldataService {

    @Autowired
    private Dao<User, String> userDAO;

    @Autowired
    private Dao<Person, String> personDAO;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Transactional
    public void fillPerson(){
        Person person = new Person();
        person.setFirstName("Alexey");
        person.setLastName("Drapun");
        ZoneId defaultZoneId = ZoneId.systemDefault();
        Date date = Date.from(LocalDate.parse("1988-09-17").atStartOfDay(defaultZoneId).toInstant());
        //person.setDob(date);
        User user = new User();

        user.setLogin("admin");
        user.setPassword(encoder.encode("password"));
        person.setUser(user);


        UserRole userRole = new UserRole();

        user.setUserRoles(new ArrayList<>(Arrays.asList(userRole)));

        Role role = new Role();
        userRole.setRole(role);
        userRole.setUser(user);
        PermissionForRole permission = new PermissionForRole();
        permission.setName("test");

        RolePermission rolePermission = new RolePermission();
        rolePermission.setRole(role);
        rolePermission.setPermission(permission);
        role.setRoleName("ROLE_ADMIN");
        role.setRolePermissions(new ArrayList<>(Arrays.asList(rolePermission)));


        personDAO.add(person);


    }



}
