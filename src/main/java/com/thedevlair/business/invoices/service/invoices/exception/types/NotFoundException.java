package com.thedevlair.business.invoices.service.invoices.exception.types;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String message, Object... args) {
        super(String.format(message, args));
    }
}
