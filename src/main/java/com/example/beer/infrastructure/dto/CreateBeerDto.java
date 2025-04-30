package com.example.beer.infrastructure.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class CreateBeerDto {

    @NotBlank(message = "Beer name cannot be blank")
    @Size(min = 3, max = 100, message = "Beer name must be between 3 and 100 characters")
    private String name;
    
    @NotBlank(message = "Beer style cannot be blank")
    @Size(min = 3, max = 50, message = "Beer style must be between 3 and 50 characters")
    private String style;
    
    @NotNull(message = "Alcohol content cannot be null")
    @Positive(message = "Alcohol content must be a positive number")
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
