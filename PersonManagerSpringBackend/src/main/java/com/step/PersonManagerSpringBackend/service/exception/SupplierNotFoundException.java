package com.step.PersonManagerSpringBackend.service.exception;

public class SupplierNotFoundException extends EntityNotFoundException {

    public SupplierNotFoundException(Integer id) {
        super("Supplier", id);
    }
}
