package com.example.pos.domain;

public record Concept(Integer idBeer, Integer quantity, Double unitPrice, Double price) {
    
    public Concept(Integer idBeer, Integer quantity, Double unitPrice) {
        this(idBeer, quantity, unitPrice, unitPrice * quantity);
    }

}
