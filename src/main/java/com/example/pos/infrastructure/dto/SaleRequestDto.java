package com.example.pos.infrastructure.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.util.List;

public class SaleRequestDto {
    
    @NotEmpty(message = "Concepts list cannot be empty")
    @Size(min = 1, message = "Sale must have at least one concept")
    @Valid
    private List<ConceptDto> concepts;
    
    public SaleRequestDto() {
    }
    
    public SaleRequestDto(List<ConceptDto> concepts) {
        this.concepts = concepts;
    }
    
    public List<ConceptDto> getConcepts() {
        return concepts;
    }
    
    public void setConcepts(List<ConceptDto> concepts) {
        this.concepts = concepts;
    }
}