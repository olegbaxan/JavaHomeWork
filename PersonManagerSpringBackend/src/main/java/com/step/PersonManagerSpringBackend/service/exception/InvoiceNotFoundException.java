package com.step.PersonManagerSpringBackend.service.exception;

public class InvoiceNotFoundException extends EntityNotFoundException{
    public InvoiceNotFoundException(Integer id) {
        super("Invoice", id);
    }
}
