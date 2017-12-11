package com.ills.dto;


import java.util.List;

public class ContextDTO {

    private Long oid;

    private String name;

    private PermissionDTO permission;

    private List<ViewDTO> viewList;

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PermissionDTO getPermission() {
        return permission;
    }

    public void setPermission(PermissionDTO permission) {
        this.permission = permission;
    }

    public List<ViewDTO> getViewList() {
        return viewList;
    }

    public void setViewList(List<ViewDTO> viewList) {
        this.viewList = viewList;
    }
}
