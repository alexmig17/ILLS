package com.ills.dto;

import java.util.List;

public class ViewDTO {

    private Long oid;

    private String name;

    private String uri;

    private List<ContextDTO> contexts;

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
}
