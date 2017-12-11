package com.ills.dto;

import java.util.List;

public class MenuDTO {

    private long oid;

    private String name;

    private List<MenuItemDTO> items;

    private List<MenuDTO> listMenu;

    private ContextDTO context;

    public long getOid() {
        return oid;
    }

    public void setOid(long oid) {
        this.oid = oid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MenuItemDTO> getItems() {
        return items;
    }

    public void setItems(List<MenuItemDTO> items) {
        this.items = items;
    }

    public List<MenuDTO> getListMenu() {
        return listMenu;
    }

    public void setListMenu(List<MenuDTO> listMenu) {
        this.listMenu = listMenu;
    }

    public ContextDTO getContext() {
        return context;
    }

    public void setContext(ContextDTO context) {
        this.context = context;
    }
}
