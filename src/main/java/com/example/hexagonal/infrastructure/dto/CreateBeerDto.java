package com.example.hexagonal.infrastructure.dto;

public class CreateBeerDto {

    private String name;
    private String style;
    private Double alcohol;

    public CreateBeerDto() {
    }

    public CreateBeerDto(String name, String style, Double alcohol) {
        this.name = name;
        this.style = style;
        this.alcohol = alcohol;
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

}
