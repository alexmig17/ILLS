package com.ills.controllers;


import com.ills.dto.PersonDTO;
import com.ills.entities.Person;
import com.ills.service.SimpleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.jta.JtaTransactionManager;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@Api(value = "PERSON", tags = "Person")
public class MainController {

    @Autowired
    private SimpleService simpleService;

    @ApiOperation(value = "getAllPerson", notes = "Апи для работы с loginPage")
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String loginPage(){
        SimpleService simpleService;
        return "login";
    }

    @RequestMapping(value = "getAllPersons", method = RequestMethod.GET)
    @ApiOperation(value = "getAllPersons", notes = "Апи для работы с loginPage")
    @ResponseBody
    public List<PersonDTO> getPerson(){
        return simpleService.getAllPersons();
    }

    @RequestMapping(value = "post", method = RequestMethod.POST)
    @ApiOperation(value = "setPerson", notes = "Апи для работы с loginPage")
    @ResponseBody
    public void setPerson(@RequestBody Person person){
    }

    @RequestMapping(value = "main", method = RequestMethod.GET)
    @ApiOperation(value = "main", notes = "Возвращает главную страницу")
    public String mainPage(){
        return "home";
    }

    @RequestMapping(value = "admin", method = RequestMethod.GET)
    @ApiOperation(value = "admin", notes = "Возвращает главную страницу")
    public String adminPage(){
        return "home";
    }


}
