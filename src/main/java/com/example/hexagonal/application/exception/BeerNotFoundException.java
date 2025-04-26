package com.example.hexagonal.application.exception;

public class BeerNotFoundException extends RuntimeException {
    
    public BeerNotFoundException(String message) {
        super(message);
    }

}
