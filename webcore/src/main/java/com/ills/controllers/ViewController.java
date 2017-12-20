package com.ills.controllers;

import com.ills.dto.*;
import com.ills.entities.View;
import com.ills.service.MenuService;
import com.ills.service.ViewService;
import org.hibernate.annotations.SourceType;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static com.ills.controllers.ControllerUtil.getAppContext;
import static com.ills.controllers.ControllerUtil.markItem;

@Controller
public class ViewController {

    @Autowired
    private ViewService viewService;

    @Autowired
    private MenuService menuService;

    @GetMapping(value = "**/view")
    @PreAuthorize("hasPermission(#viewId, 'view')")
    public String prepareView(@RequestParam("viewId") String viewId, Model model, HttpServletRequest request){

        MenuDTO menuDTO = menuService.getFullMenuByName("admin");
        markItem(menuDTO, getAppContext(request), viewId);
        model.addAttribute("menu", menuDTO);

        ViewDTO viewDTO = viewService.getViewById(viewId);
        for(BasedBeanDTO basedBean: viewDTO.getBasedBeans()){
            List<Dto> dtoList = viewService.getPaginatedDtoList(basedBean, 0, 10);
            System.out.println(dtoList);
        }
        return viewDTO.getJsp();
    }

//    @GetMapping(value = "**/add/view")
//    @PreAuthorize("hasPermission(#viewId, 'viewId')")
//    public String prepareAddView(@RequestParam("viewId") String id, Model model, HttpServletRequest request){
//
//        MenuDTO menuDTO = menuService.getFullMenuByName("admin");
//        markItem(menuDTO, getAppContext(request), id);
//        model.addAttribute("menu", menuDTO);
//        ViewDTO viewDTO = viewService.getViewById(id);
//        return viewDTO.getJsp();
//    }

//    @PostMapping(value = "**/add/view")
//    @PreAuthorize("hasPermission(#viewId, 'viewId')")
//    public String postAddView(@RequestParam("id") String id, Model model, HttpServletRequest request, @ModelAttribute StudentDTO studentDTO){
//        System.out.println("hi");
//        MenuDTO menuDTO = menuService.getFullMenuByName("admin");
//        markItem(menuDTO, getAppContext(request), id);
//        model.addAttribute("menu", menuDTO);
//        ViewDTO viewDTO = viewService.getViewById(id);
//        return viewDTO.getJsp();
//    }


}
