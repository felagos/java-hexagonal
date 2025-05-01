package com.example.pos.application.exception;

public class SaleNotFoundException extends RuntimeException {

    public SaleNotFoundException(String message) {
        super(message);
    }

}
