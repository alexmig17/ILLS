package com.ills.controllers;

import com.ills.dto.MenuDTO;
import com.ills.dto.StudentDTO;
import com.ills.dto.ViewDTO;
import com.ills.service.MenuService;
import com.ills.service.StudentService;
import com.ills.service.ViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import static com.ills.controllers.ControllerUtil.getAppContext;
import static com.ills.controllers.ControllerUtil.markItem;

@Controller
public class StudentController {

    @Autowired
    private ViewService viewService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private MenuService menuService;

    @PostMapping(value = "**/students/add/view")
    @PreAuthorize("hasPermission(#viewId, 'viewId')")
    public String postAddView(@RequestParam("viewId") String viewId, Model model, HttpServletRequest request, @ModelAttribute StudentDTO studentDTO){
        MenuDTO menuDTO = menuService.getFullMenuByName("admin");

        markItem(menuDTO, getAppContext(request), viewId);

        model.addAttribute("menu", menuDTO);

        ViewDTO viewDTO = viewService.getViewById(viewId);

        return viewDTO.getJsp();
    }

    @GetMapping(value = "**/students/add/view")
    @PreAuthorize("hasPermission(#viewId, 'viewId')")
    public String prepareAddView(@RequestParam("viewId") String viewId, Model model, HttpServletRequest request){

        MenuDTO menuDTO = menuService.getFullMenuByName("admin");
        markItem(menuDTO, getAppContext(request), viewId);
        model.addAttribute("menu", menuDTO);
        ViewDTO viewDTO = viewService.getViewById(viewId);
        return viewDTO.getJsp();
    }

}
