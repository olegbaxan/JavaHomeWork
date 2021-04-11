package com.step.PersonManagerSpringBackend.service.exception;

public class FlatNotFoundException extends EntityNotFoundException{
    public FlatNotFoundException(Integer id) {
        super("Flat", id);
    }
}
