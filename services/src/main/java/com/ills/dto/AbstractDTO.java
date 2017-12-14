package com.ills.dto;

import java.util.Map;

/**
 * Created by Alex on 13.12.2017.
 */
public class AbstractDTO {

    private String basedBeanClass;

    private Map<String, String> beanProperties;

    private Map<String, AbstractDTO> relations;

    public String getBasedBeanClass() {
        return basedBeanClass;
    }

    public void setBasedBeanClass(String basedBeanClass) {
        this.basedBeanClass = basedBeanClass;
    }

    public Map<String, String> getBeanProperties() {
        return beanProperties;
    }

    public void setBeanProperties(Map<String, String> beanProperties) {
        this.beanProperties = beanProperties;
    }

    public Map<String, AbstractDTO> getRelations() {
        return relations;
    }

    public void setRelations(Map<String, AbstractDTO> relations) {
        this.relations = relations;
    }
}
