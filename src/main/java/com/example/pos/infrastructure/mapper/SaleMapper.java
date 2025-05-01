package com.example.pos.infrastructure.mapper;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.pos.domain.Concept;
import com.example.pos.domain.Sale;
import com.example.pos.infrastructure.dto.ConceptDto;
import com.example.pos.infrastructure.dto.ConceptResponseDto;
import com.example.pos.infrastructure.dto.SaleRequestDto;
import com.example.pos.infrastructure.dto.SaleResponseDto;
import com.example.pos.infrastructure.entity.SaleEntity;
import com.example.pos.infrastructure.entity.ConceptEntity;

@Component
public class SaleMapper {

    public Sale toEntity(SaleRequestDto dto) {
        List<Concept> concepts = dto.getConcepts().stream()
            .map(this::toEntity)
            .collect(Collectors.toList());
        
        return new Sale(LocalDateTime.now(), concepts);
    }
    
    public Concept toEntity(ConceptDto dto) {
        return new Concept(dto.getIdBeer(), dto.getQuantity(), dto.getUnitPrice());
    }
    
    public SaleResponseDto toDto(Sale sale) {
        List<ConceptResponseDto> conceptDtos = sale.concepts().stream()
            .map(this::toDto)
            .collect(Collectors.toList());
        
        SaleResponseDto responseDto = new SaleResponseDto();
        responseDto.setId(sale.id());
        responseDto.setDate(sale.date());
        responseDto.setTotal(sale.total());
        responseDto.setConcepts(conceptDtos);
            
        return responseDto;
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