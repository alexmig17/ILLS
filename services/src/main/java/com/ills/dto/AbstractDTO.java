package com.ills.dto;

import java.util.List;
import java.util.Map;

/**
 * Created by Alex on 13.12.2017.
 */
public class AbstractDTO {

    private String basedBeanClass;

    private Map<String, String> beanPropertyValues;

    private Map<String, List<AbstractDTO>> relations;

    public String getBasedBeanClass() {
        return basedBeanClass;
    }

    public void setBasedBeanClass(String basedBeanClass) {
        this.basedBeanClass = basedBeanClass;
    }

    public Map<String, String> getBeanProperties() {
        return beanPropertyValues;
    }

    public void setBeanProperties(Map<String, String> beanProperties) {
        this.beanPropertyValues = beanProperties;
    }

    public Map<String, String> getBeanPropertyValues() {
        return beanPropertyValues;
    }

    public void setBeanPropertyValues(Map<String, String> beanPropertyValues) {
        this.beanPropertyValues = beanPropertyValues;
    }

    public Map<String, List<AbstractDTO>> getRelations() {
        return relations;
    }

    public void setRelations(Map<String, List<AbstractDTO>> relations) {
        this.relations = relations;
    }
}
