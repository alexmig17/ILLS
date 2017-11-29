package com.ills.controllers;


import com.ills.dto.PersonDTO;
import com.ills.entities.Person;
import com.ills.service.SimpleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Person> getPerson(){
        return simpleService.getAllPersons();
    }

    @RequestMapping(value = "post", method = RequestMethod.POST)
    @ApiOperation(value = "setPerson", notes = "Апи для работы с loginPage")
    @ResponseBody
    public void setPerson(@RequestBody Person person){
    }

    public static void main(String[] args) {

        JtaTransactionManager txManager = null;
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setName("SomeTxName");//setName
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_MANDATORY);//PROPAGATION_MANDATORY
        def.setIsolationLevel(TransactionDefinition.ISOLATION_REPEATABLE_READ);//setIsolationLevel

        TransactionStatus status = txManager.getTransaction(def);//getTransaction
        try {
// execute your business logic here
        }
        catch (Exception ex) {
            txManager.rollback(status);//rollback
            throw ex;
        }
        txManager.commit(status);//commit
    }





}
