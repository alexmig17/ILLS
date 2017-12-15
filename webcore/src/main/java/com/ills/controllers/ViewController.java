package com.ills.controllers;

import com.ills.dto.*;
import com.ills.entities.View;
import com.ills.service.MenuService;
import com.ills.service.ViewService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ViewController {

    @Autowired
    private ViewService viewService;

    @Autowired
    private MenuService menuService;

    @GetMapping(value = "**/view")
    @PreAuthorize("hasPermission(#id, 'view')")
    public String prepareView(@RequestParam("id") String id, Model model, HttpServletRequest request){

        MenuDTO menuDTO = menuService.getFullMenuByName("admin");
        markItem(menuDTO, getAppContext(request));
        model.addAttribute("menu", menuDTO);

        ViewDTO viewDTO = viewService.getViewById(id);
        for(BasedBeanDTO basedBean: viewDTO.getBasedBeans()){
            List<Dto> dtoList = viewService.getPaginatedDtoList(basedBean, 0, 10);
            System.out.println(dtoList);
        }
        return viewDTO.getJsp();
    }

    private String getAppContext(HttpServletRequest request){
        String uri = request.getRequestURI();
        uri = uri.replace("/view", "");
        uri = uri.replace("/ills/", "");
        return uri.replace("/", ".");
    }

    private void markItem(MenuDTO menu, String context){

        for (MenuItemDTO menuItemDTO : menu.getItems()) {
            String checkingContext = menuItemDTO.getContext().getName();
            if(context.startsWith(checkingContext)){
                menuItemDTO.setSelected(true);
            }
        }
    }
}
