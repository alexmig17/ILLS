package com.ills.controllers;

import com.ills.dto.BasedBeanDTO;
import com.ills.dto.Dto;
import com.ills.dto.ViewDTO;
import com.ills.entities.View;
import com.ills.service.ViewService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ViewController {

    @Autowired
    private ViewService viewService;


    @RequestMapping(value = "**/view", method= RequestMethod.GET)
    @PreAuthorize("hasPermission(#id, 'view')")
    public String prepareView(@RequestParam("id") String id, Model model){

        ViewDTO viewDTO = viewService.getViewById(id);
        for(BasedBeanDTO basedBean: viewDTO.getBasedBeans()){
            List<Dto> dtoList = viewService.getPaginatedDtoList(basedBean, 0, 10);
            System.out.println(dtoList);
        }
        return viewDTO.getJsp();
    }

}
