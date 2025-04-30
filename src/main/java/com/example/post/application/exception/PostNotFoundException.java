package com.example.post.application.exception;

public class PostNotFoundException extends RuntimeException {
    
    public PostNotFoundException(String message) {
        super(message);
    }

}