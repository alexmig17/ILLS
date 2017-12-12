package com.ills.controllers;

import org.springframework.context.annotation.Role;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ViewController {

    @RequestMapping(value = "**/view", method= RequestMethod.GET)
    @PostAuthorize("hasAuthority('MUSER')")
    public String prepareView(@RequestParam("id") String id){


        return "";
    }

}
