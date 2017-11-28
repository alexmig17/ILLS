package com.ills.controllers;

import com.ills.service.FilldataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("fillDb")
public class FillDataController {

    @Autowired
    private FilldataService filldataService;

    @RequestMapping("person")
    @ResponseBody
    public String fillPerson(){

        //filldataService.fillUser();
        filldataService.fillPerson();
        return "";
    }


}
