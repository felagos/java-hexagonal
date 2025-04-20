package com.example.hexagonal.domain.exception;

public class BeerNotFoundException extends RuntimeException {
    
    public BeerNotFoundException(String message) {
        super(message);
    }

}
