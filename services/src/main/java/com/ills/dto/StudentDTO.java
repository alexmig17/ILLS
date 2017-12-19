package com.ills.dto;

/**
 * Created by Alex on 14.12.2017.
 */
public class StudentDTO extends AbstractEntityDtoConverter<ViewDTO> implements Dto{


    private Long oid;

    private PersonDTO person;

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public PersonDTO getPerson() {
        return person;
    }

    public void setPerson(PersonDTO person) {
        this.person = person;
    }
}
