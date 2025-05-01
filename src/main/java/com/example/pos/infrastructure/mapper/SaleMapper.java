package com.example.pos.infrastructure.mapper;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.pos.domain.Concept;
import com.example.pos.domain.Sale;
import com.example.pos.infrastructure.dto.ConceptDto;
import com.example.pos.infrastructure.dto.ConceptResponseDto;
import com.example.pos.infrastructure.dto.SaleCreateDto;
import com.example.pos.infrastructure.dto.SaleCreatedDto;
import com.example.pos.infrastructure.entity.SaleEntity;

@Component
public class SaleMapper {

    public Sale toEntity(SaleCreateDto dto) {
        List<Concept> concepts = dto.getConcepts().stream()
                .map(this::toEntity)
                .collect(Collectors.toList());

        return new Sale(LocalDateTime.now(), concepts);
    }

    public Concept toEntity(ConceptDto dto) {
        return new Concept(dto.getIdBeer(), dto.getQuantity(), dto.getUnitPrice());
    }

    public SaleCreatedDto toDto(Sale sale) {
        List<ConceptResponseDto> conceptDtos = sale.concepts().stream()
                .map(this::toDto)
                .collect(Collectors.toList());

        return new SaleCreatedDto(sale.id(), sale.date(), sale.total(), conceptDtos);
    }

    public ConceptResponseDto toDto(Concept concept) {
        ConceptResponseDto dto = new ConceptResponseDto();
        dto.setIdBeer(concept.idBeer());
        dto.setQuantity(concept.quantity());
        dto.setUnitPrice(concept.unitPrice());
        dto.setPrice(concept.price());
        return dto;
    }

    public SaleEntity toEntity(Sale sale) {
        return SaleEntity.fromDomain(sale);
    }

    public Sale toDomain(SaleEntity entity) {
        return entity.toDomain();
    }
}