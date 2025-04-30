package com.example.beer.infrastructure.dto;

import com.example.beer.domain.Beer;

public class BeerResponseDto {

    private Integer id;
    private String name;
    private String style;
    private Double alcohol;
    private boolean isStrong;

    public BeerResponseDto() {
    }

    public BeerResponseDto(Integer id, String name, String style, Double alcohol, boolean isStrong) {
        this.id = id;
        this.name = name;
        this.style = style;
        this.alcohol = alcohol;
        this.isStrong = isStrong;
    }

    // Factory method to create from domain object
    public static BeerResponseDto fromDomain(Beer beer) {
        return new BeerResponseDto(
            beer.id(),
            beer.name(),
            beer.style(),
            beer.alcohol(),
            beer.isStrongBeer()
        );
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public Double getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(Double alcohol) {
        this.alcohol = alcohol;
    }

    public boolean isStrong() {
        return isStrong;
    }

    public void setStrong(boolean isStrong) {
        this.isStrong = isStrong;
    }
}