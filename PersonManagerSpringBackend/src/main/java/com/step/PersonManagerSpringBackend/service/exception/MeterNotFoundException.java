package com.step.PersonManagerSpringBackend.service.exception;

public class MeterNotFoundException extends EntityNotFoundException{
    public MeterNotFoundException(Integer id) {
        super("Meter", id);
    }
}
