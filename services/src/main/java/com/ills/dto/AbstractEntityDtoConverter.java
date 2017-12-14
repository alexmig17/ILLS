package com.ills.dto;

import com.ills.entities.EntityA;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class  AbstractEntityDtoConverter<T extends Dto> implements EntityDtoConverter{

    @Autowired
    ModelMapper modelMapper;

    @Override
    public <T extends Dto> T translateEntityIntoDto(EntityA entity, Class<T> tClass) {
        T dto =  modelMapper.map(entity, tClass);
        return dto;
    }
}
