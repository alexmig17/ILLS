package com.ills.controllers;

import com.ills.dto.MenuDTO;
import com.ills.dto.MenuItemDTO;
import com.ills.dto.ViewDTO;

import javax.servlet.http.HttpServletRequest;

public class ControllerUtil {

    public static String getAppContext(HttpServletRequest request){
        String uri = request.getRequestURI();
        uri = uri.replace("/view", "");
        uri = uri.replace("/ills/", "");
        return uri.replace("/", ".");
    }

    public static void markItem(MenuDTO menu, String context, String viewId){

        for (MenuItemDTO menuItemDTO : menu.getItems()) {
            String checkingContext = menuItemDTO.getContext().getName();
            if(context.startsWith(checkingContext)){
                menuItemDTO.setSelected(true);
                if (context.equals(checkingContext)){
                    menuItemDTO.getContext().getViewList();
                    for (ViewDTO viewDTO : menuItemDTO.getContext().getViewList()) {
                        if (viewDTO.getId().equals(viewId)){
                            viewDTO.setSelected(true);
                        }
                    }
                }
            }
        }
    }
}
