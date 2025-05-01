package com.example.pos.infrastructure.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class ConceptDto {
    
    @NotNull(message = "Beer ID cannot be null")
    private Integer idBeer;
    
    @NotNull(message = "Quantity cannot be null")
    @Min(value = 1, message = "Quantity must be at least 1")
    private Integer quantity;
    
    @Positive(message = "Unit price must be positive")
    private Double unitPrice;
    
    public ConceptDto() {
    }
    
    public ConceptDto(Integer idBeer, Integer quantity, Double unitPrice) {
        this.idBeer = idBeer;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
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
}