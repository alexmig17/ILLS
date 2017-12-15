package com.ills.service;

import com.ills.dao.Dao;
import com.ills.dto.Dto;
import com.ills.dto.StudentDTO;
import com.ills.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class FilldataService {

    @Autowired
    private Dao<User, Long> userDAO;

    @Autowired
    private Dao<Person, Long> personDAO;

    @Autowired
    private Dao<Menu, Long> menuDAO;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Transactional
    public void fillPerson(){
        Person person = new Person();
        person.setFirstName("Alexey");
        person.setLastName("Drapun");
        //ZoneId defaultZoneId = ZoneId.systemDefault();
        //Date date = Date.from(LocalDate.parse("1988-09-17").atStartOfDay(defaultZoneId).toInstant());
        //person.setDob(date);
        User user = new User();
        user.setLogin("admin");
        user.setPassword(encoder.encode("password"));
        person.setUser(user);
        UserRole userRole = new UserRole();
        user.setUserRoles(new ArrayList<>(Arrays.asList(userRole)));
        Role role = new Role();
        userRole.setRole(role);
        userRole.setUser(user);
        Permission permission = new Permission();
        permission.setName("test");
        permission.setType(Permission.PermissionType.ROLE);

        RolePermission rolePermission = new RolePermission();
        rolePermission.setRole(role);
        rolePermission.setPermission(permission);
        role.setRoleName("ROLE_ADMIN");
        role.setRolePermissions(new ArrayList<>(Arrays.asList(rolePermission)));
        personDAO.add(person);

        Menu menu = createMenu("Admin");

        MenuItem itemForStudents = attachItem(menu, "Students");
        View view = createView(itemForStudents.getName(), "std.list.default",Arrays.asList(itemForStudents.getContext()), "students");

        createBasedBean(view, Student.class, StudentDTO.class);
        createView(itemForStudents.getName() + " v1", "std.v1",Arrays.asList(itemForStudents.getContext()), "students");

        MenuItem itemForMenu = attachItem(menu, "Menu");
        createView(itemForMenu.getName(), "mnu.default",Arrays.asList(itemForMenu.getContext()), "menu");

        /*MenuItem item = attachItem(menu, "Students");
        createView(item.getName(), "admin/students", Arrays.asList(item.getContext()));*/

        menuDAO.add(menu);
    }

    private  void createBasedBean(View view, Class<? extends EntityA> entityClass, Class<? extends Dto> dtoClass){
        BasedBean basedBean = new BasedBean();
        basedBean.setDtoName(dtoClass.getName());
        basedBean.setEntityName(entityClass.getName());
        basedBean.setName(entityClass.getSimpleName());
        List<BasedBean> basedBeans = view.getBasedBeans();
        basedBeans = basedBeans == null ? new ArrayList<>() : basedBeans;
        view.setBasedBeans(basedBeans);
        basedBeans.add(basedBean);
    }


    private View createView(String name,  String id, List<Context> contexts, String jsp){

        View view = new View();
        view.setName(name);
        view.setContexts(contexts);
        view.setId(id);
        view.setJsp(jsp);

        for (Context context : contexts) {
            List<View> viewList = context.getViewList();
            viewList = viewList == null ? new ArrayList<>() : viewList;
            context.setViewList(viewList);
            viewList.add(view);
        }

        return view;
    }

    private Menu createMenu(String name){
        Menu menu = new Menu();
        menu.setName(name);
        Context context = new Context();
        context.setName(name.toLowerCase());
        menu.setContext(context);
        return menu;
    }

    private MenuItem attachItem(Menu menu, String itemName){
        MenuItem item = new MenuItem();

        Context contextItem = new Context();
        String prefix = menu.getContext().getName();
        String itemContextName = prefix + "." + itemName.toLowerCase();
        contextItem.setName(itemContextName);
        item.setContext(contextItem);
        item.setMenu(menu);
        item.setName(itemName);
        List<MenuItem> listItems = menu.getItems();
        listItems = listItems == null ? new ArrayList<>(): listItems;
        menu.setItems(listItems);
        listItems.add(item);
        return  item;
    }
}
