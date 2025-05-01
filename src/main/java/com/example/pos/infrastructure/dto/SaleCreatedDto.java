package com.example.pos.infrastructure.dto;

import java.time.LocalDateTime;
import java.util.List;

public record SaleCreatedDto(
    Integer id, 
    LocalDateTime date,
    Double total, 
    List<ConceptResponseDto> concepts
) {
}