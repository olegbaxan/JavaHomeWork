package com.step.PersonManagerSpringBackend.service.exception;

public class PersonNotFoundException extends EntityNotFoundException{

    public PersonNotFoundException(Integer id) {
        super("Person", id);
    }
}
