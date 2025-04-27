package com.example.hexagonal.application.exception;

public class PostNotFoundException extends RuntimeException {
    
    public PostNotFoundException(String message) {
        super(message);
    }

}