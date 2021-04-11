package com.step.PersonManagerSpringBackend.service.exception;

public class AddressNotFoundException extends EntityNotFoundException{
    public AddressNotFoundException(Integer id) {
        super("Address", id);
    }
}
