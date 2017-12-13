package com.ills.service.security;

import com.ills.entities.Context;
import com.ills.entities.Permission;
import com.ills.entities.View;
import com.ills.service.ContextService;
import com.ills.service.ViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Alex on 12.12.2017.
 */
@Service("myPermissionEvaluator")
public class MyPermissionEvaluator implements PermissionEvaluator {

    @Autowired
    private ViewService viewService;

    @Autowired
    private ContextService contextService;

    /*@Transactional(readOnly=true) in some reason it doesn't work*/
    @Override
    public boolean hasPermission(Authentication authentication, Object o, Object o1){
        boolean hasPermission = false;

        if ("view".equals(o1)) {

            String contextName = getAppContext();
            Context context = contextService.getContextByName(contextName);
            if (context == null){
                throw new RuntimeException("can not find context with name " + contextName);
            }
            View view = viewService.getViewById((String)o);

            if (view == null){
                throw new RuntimeException("can not find view with id " + o);
            }
            List<String> permissions = new ArrayList<>(2);
            addPermission(view.getPermission(), permissions);
            addPermission(context.getPermission(), permissions);

            if (!permissions.isEmpty()){
                hasPermission = authentication.getAuthorities().containsAll(permissions);
            } else {
                hasPermission = true;
            }
        }
        return hasPermission;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable serializable, String s, Object o) {
        return true;
    }

    private void addPermission(Permission permission, List<String> permissions){
        String permissionString = permission == null ? null : permission.getName();
        if (!StringUtils.isEmpty(permissionString)){
            permissions.add(permissionString);
        }
    }


    private String getAppContext(){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String uri = request.getRequestURI();
        uri = uri.replace("/view", "");
        uri = uri.replace("/ills/", "");
        return uri.replace("/", ".");
    }

}
