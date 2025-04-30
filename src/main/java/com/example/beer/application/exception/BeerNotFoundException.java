package com.example.beer.application.exception;

public class BeerNotFoundException extends RuntimeException {
    
    public BeerNotFoundException(String message) {
        super(message);
    }

}