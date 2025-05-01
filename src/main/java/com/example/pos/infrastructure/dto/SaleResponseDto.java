package com.example.pos.infrastructure.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import java.time.LocalDateTime;
import java.util.List;

public class SaleResponseDto {
    
    private Integer id;
    
    @NotNull
    @PastOrPresent(message = "Sale date cannot be in the future")
    private LocalDateTime date;
    
    @NotNull
    @Positive(message = "Total must be positive")
    private Double total;
    
    @NotEmpty(message = "Concepts list cannot be empty")
    @Valid
    private List<ConceptResponseDto> concepts;
    
    public SaleResponseDto() {
    }
    
    public SaleResponseDto(Integer id, LocalDateTime date, Double total, List<ConceptResponseDto> concepts) {
        this.id = id;
        this.date = date;
        this.total = total;
        this.concepts = concepts;
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public LocalDateTime getDate() {
        return date;
    }
    
    public void setDate(LocalDateTime date) {
        this.date = date;
    }
    
    public Double getTotal() {
        return total;
    }
    
    public void setTotal(Double total) {
        this.total = total;
    }
    
    public List<ConceptResponseDto> getConcepts() {
        return concepts;
    }
    
    public void setConcepts(List<ConceptResponseDto> concepts) {
        this.concepts = concepts;
    }
}