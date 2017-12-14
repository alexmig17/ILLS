package com.ills.dto;

import com.ills.entities.EntityA;

import java.util.List;

@FunctionalInterface
public interface EntityDtoConverter {

    public <T extends Dto> T translateEntityIntoDto(EntityA entity, Class<T> tClass);
}
