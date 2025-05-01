package com.example.pos.infrastructure.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class ConceptResponseDto {
    
    @NotNull
    private Integer idBeer;
    
    @NotNull
    @Positive(message = "Quantity must be positive")
    private Integer quantity;
    
    @NotNull
    @Positive(message = "Unit price must be positive")
    private Double unitPrice;
    
    @NotNull
    @Positive(message = "Total price must be positive")
    private Double price;
    
    public ConceptResponseDto() {
    }
    
    public ConceptResponseDto(Integer idBeer, Integer quantity, Double unitPrice, Double price) {
        this.idBeer = idBeer;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.price = price;
    }
    
    public Integer getIdBeer() {
        return idBeer;
    }
    
    public void setIdBeer(Integer idBeer) {
        this.idBeer = idBeer;
    }
    
    public Integer getQuantity() {
        return quantity;
    }
    
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    
    public Double getUnitPrice() {
        return unitPrice;
    }
    
    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }
    
    public Double getPrice() {
        return price;
    }
    
    public void setPrice(Double price) {
        this.price = price;
    }
}