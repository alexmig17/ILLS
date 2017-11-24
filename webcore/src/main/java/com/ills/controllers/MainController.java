package com.ills.controllers;


import com.ills.dto.PersonDTO;
import com.ills.entities.Person;
import com.ills.service.SimpleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.jta.JtaTransactionManager;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MainController {

    @Autowired
    private SimpleService simpleService;

    @RequestMapping(value = "login")

    public String loginPage(){

        SimpleService simpleService;
        return "login";
    }

    @RequestMapping("getPerson")
    @ResponseBody
    public String getPerson(){
        simpleService.getAnyPerson();
        /*if(true){
            throw new NullPointerException();
        }*/
        return simpleService.getAnyPerson().toString();
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
