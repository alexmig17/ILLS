package com.ills.service.security;

import com.ills.entities.Role;
import com.ills.entities.RolePermission;
import com.ills.entities.User;
import com.ills.entities.UserRole;
import com.ills.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 01.12.2017.
 */
@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService{

    @Autowired
    private UserService userService;

    @Transactional(readOnly=true)
    @Override
    public UserDetails loadUserByUsername(String login)
            throws UsernameNotFoundException {
        User user = userService.getUserByLogin(login);

        if(user==null){
            throw new UsernameNotFoundException("User with name " + login + " is not found");
        }
        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(),
                true, true, true, true, getGrantedAuthorities(user));
    }


    private List<GrantedAuthority> getGrantedAuthorities(User user){
        List<GrantedAuthority> authorities = new ArrayList<>();

        for(UserRole userRole : user.getUserRoles()){
            Role role  =userRole.getRole();
            for (RolePermission rolePermission : role.getRolePermissions()) {
                String permissionName = rolePermission.getPermission().getName();
                authorities.add(new SimpleGrantedAuthority("OP_" + permissionName));
            }
        }
        System.out.print("authorities :"+authorities);
        return authorities;
    }

}
