package com.example.beer.domain;

public record Post(Integer userId, Integer id, String title, String body) {
    
    public boolean isValid() {
        return title != null && !title.isBlank() && 
               body != null && !body.isBlank();
    }
}