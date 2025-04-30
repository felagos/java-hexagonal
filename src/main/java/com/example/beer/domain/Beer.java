package com.example.beer.domain;

public record Beer(Integer id, String name, String style, Double alcohol) {

    public Beer(String name, String style, Double alcohol) {
        this(null, name, style, alcohol);
    }

    public boolean isStrongBeer() {
        return this.alcohol > 7.5;
    }

}
