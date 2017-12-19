package com.ills.dto;

import java.util.List;

public class ViewDTO extends AbstractEntityDtoConverter<ViewDTO> implements Dto{

    private Long oid;

    private String id;

    private String name;

    private String uri;

    private String jsp;

    private List<BasedBeanDTO> basedBeans;

    private List<ContextDTO> contexts;

    private PermissionDTO permission;

    private boolean selected;

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

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public List<ContextDTO> getContexts() {
        return contexts;
    }

    public void setContexts(List<ContextDTO> contexts) {
        this.contexts = contexts;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJsp() {
        return jsp;
    }

    public void setJsp(String jsp) {
        this.jsp = jsp;
    }

    public List<BasedBeanDTO> getBasedBeans() {
        return basedBeans;
    }

    public void setBasedBeans(List<BasedBeanDTO> basedBeans) {
        this.basedBeans = basedBeans;
    }

    public PermissionDTO getPermission() {
        return permission;
    }

    public void setPermission(PermissionDTO permission) {
        this.permission = permission;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
