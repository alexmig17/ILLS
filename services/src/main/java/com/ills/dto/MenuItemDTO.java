package com.ills.dto;

import java.util.List;

public class MenuItemDTO {

    private long oid;

    private int level;

    private String context;

    private String name;

    private MenuDTO menu;

    private List<MenuItemDTO> items;

    private MenuItemDTO item;

    public long getOid() {
        return oid;
    }

    public void setOid(long oid) {
        this.oid = oid;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MenuDTO getMenu() {
        return menu;
    }

    public void setMenu(MenuDTO menu) {
        this.menu = menu;
    }

    public List<MenuItemDTO> getItems() {
        return items;
    }

    public void setItems(List<MenuItemDTO> items) {
        this.items = items;
    }

    public MenuItemDTO getItem() {
        return item;
    }

    public void setItem(MenuItemDTO item) {
        this.item = item;
    }
}
